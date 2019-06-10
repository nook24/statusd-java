package monitoring;

import com.github.cliftonlabs.json_simple.JsonArray;
import com.github.cliftonlabs.json_simple.JsonObject;
import oshi.SystemInfo;
import oshi.hardware.*;
import oshi.software.os.FileSystem;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;
import oshi.software.os.OperatingSystemVersion;

public class MonitoringCore {

    private SystemInfo si;
    private HardwareAbstractionLayer hal;
    private OperatingSystem os;

    public MonitoringCore() {
        this.si = new SystemInfo();
        this.hal = this.si.getHardware();
        this.os = this.si.getOperatingSystem();
    }

    public JsonObject getCpuInfo() {

        JsonObject json = new JsonObject();

        CentralProcessor cpu = this.hal.getProcessor();

        json.put("Identifier", cpu.getIdentifier());
        json.put("Name", cpu.getName());
        json.put("Model", cpu.getModel());
        json.put("Family", cpu.getFamily());

        json.put("Vendor", cpu.getVendor());

        json.put("PhysicalProcessorCount", cpu.getPhysicalProcessorCount());
        json.put("LogicalProcessorCount", cpu.getLogicalProcessorCount());

        return json;
    }

    public JsonObject getOsInfo() {
        JsonObject json = new JsonObject();

        OperatingSystemVersion osVersion = this.os.getVersion();

        json.put("Version", osVersion.getVersion());
        json.put("BuildNumber", osVersion.getBuildNumber());
        json.put("CodeName", osVersion.getCodeName());
        json.put("Family", this.os.getFamily());
        json.put("str", osVersion.toString());
        return json;
    }

    public JsonObject getMemoryInfo() {
        JsonObject json = new JsonObject();
        JsonObject memory = new JsonObject();
        JsonObject swap = new JsonObject();

        GlobalMemory mem = this.hal.getMemory();

        memory.put("Total", mem.getTotal());
        memory.put("Available", mem.getAvailable());
        memory.put("Used", mem.getTotal() - mem.getAvailable());
        memory.put("PageSize", mem.getPageSize());

        swap.put("SwapTotal", mem.getSwapTotal());
        swap.put("SwapUsed", mem.getSwapUsed());
        swap.put("SwapPagesIn", mem.getSwapPagesIn());
        swap.put("SwapPagesOut", mem.getSwapPagesOut());

        json.put("memory", memory);
        json.put("swap", swap);

        return json;
    }

    public JsonObject getDiskInfo() {
        JsonObject jsonDisksAndVolumes = new JsonObject();
        JsonArray jsonVolumes = new JsonArray();
        JsonArray jsonDisks = new JsonArray();

        HWDiskStore[] disks = this.hal.getDiskStores();

        FileSystem fs = this.os.getFileSystem();
        OSFileStore[] fileStores = fs.getFileStores();

        for (OSFileStore osFs : fileStores) {
            JsonObject volume = new JsonObject();
            volume.put("Description", osFs.getDescription());
            volume.put("FreeInodes", osFs.getFreeInodes());
            volume.put("LogicalVolume", osFs.getLogicalVolume());
            volume.put("Mountpoint", osFs.getMount());
            volume.put("Name", osFs.getName());
            volume.put("TotalInodes", osFs.getTotalInodes());
            volume.put("TotalSpace", osFs.getTotalSpace());
            volume.put("Type", osFs.getType());
            volume.put("UsableSpace", osFs.getUsableSpace());
            volume.put("UUID", osFs.getUUID());
            volume.put("Volume", osFs.getVolume());

            jsonVolumes.add(volume);
        }

        jsonDisksAndVolumes.put("Volumes", jsonVolumes);

        for (HWDiskStore _disk : disks) {
            JsonObject disk = new JsonObject();

            disk.put("CurrentQueueLength", _disk.getCurrentQueueLength());
            disk.put("Model", _disk.getModel());
            disk.put("Name", _disk.getName());
            disk.put("ReadBytes", _disk.getReadBytes());
            disk.put("Reads", _disk.getReads());
            disk.put("Serial", _disk.getSerial());
            disk.put("Size", _disk.getSize());
            disk.put("Timestamp", _disk.getTimeStamp());
            disk.put("TransferTime", _disk.getTransferTime());
            disk.put("WriteBytes", _disk.getWriteBytes());
            disk.put("Writes", _disk.getWrites());

            HWPartition[] partitions = _disk.getPartitions();
            JsonArray jsonPartitions = new JsonArray();
            for (HWPartition _partition : partitions) {
                JsonObject partition = new JsonObject();

                partition.put("Identification", _partition.getIdentification());
                partition.put("Major", _partition.getMajor());
                partition.put("Minor", _partition.getMinor());
                partition.put("Mountpoint", _partition.getMountPoint());
                partition.put("Name", _partition.getName());
                partition.put("Size", _partition.getSize());
                partition.put("Type", _partition.getType());
                partition.put("Uuid", _partition.getUuid());

                jsonPartitions.add(partition);
            }

            disk.put("Partitions", jsonPartitions);
            jsonDisks.add(disk);
        }
        jsonDisksAndVolumes.put("Disks", jsonDisks);

        return jsonDisksAndVolumes;
    }

}
