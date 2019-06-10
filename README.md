# Statusd (alpha)
Java Version

## Todos
- [x] Checkout [OSHI](https://github.com/oshi/oshi)
- [x] Implement basic json schema
- [x] OS Info
- [x] CPU Info
- [x] Memory usage
- [ ] CPU Usage (% and load avg)
- [x] Disk Usage
- [ ] Disk IO
- [ ] Disk Wait
- [ ] Running processes (with %cpu and memory)
- [ ] Add config file
- [ ] Add plugin executor

### Example (Windows)
```json
{
   "Agent":{
      "Os_archc":"amd64",
      "Os_name":"Windows 10",
      "Os_version":"10.0",
      "Version":"1.0.0-alpha",
      "Java_version":"12.0.1",
      "Java_vendor":"Oracle Corporation",
      "Name":"Statusd-java"
   },
   "OS":{
      "str":"10 build 17763",
      "BuildNumber":"17763",
      "CodeName":"",
      "Version":"10",
      "Family":"Windows"
   },
   "Memory":{
      "memory":{
         "PageSize":4096,
         "Used":7701504000,
         "Total":17115303936,
         "Available":9413799936
      },
      "swap":{
         "SwapPagesOut":694823,
         "SwapPagesIn":29558290,
         "SwapTotal":5905580032,
         "SwapUsed":24416
      }
   },
   "CPU":{
      "Identifier":"Intel64 Family 6 Model 158 Stepping 9",
      "PhysicalProcessorCount":4,
      "Model":"158",
      "Family":"6",
      "Vendor":"GenuineIntel",
      "LogicalProcessorCount":8,
      "Name":"Intel(R) Core(TM) i7-7700K CPU @ 4.20GHz"
   },
   "Disks":{
      "Volumes":[
         {
            "UsableSpace":16736899072,
            "Type":"NTFS",
            "Description":"Fixed drive",
            "Volume":"\\\\?\\Volume{539f0ce6-0000-0000-0000-100000000000}\\",
            "TotalInodes":-1,
            "TotalSpace":480102051840,
            "FreeInodes":-1,
            "LogicalVolume":"",
            "UUID":"539f0ce6-0000-0000-0000-100000000000",
            "Mountpoint":"D:\\",
            "Name":"Lokale Festplatte (D:)"
         },
         {
            "UsableSpace":68898816,
            "Type":"NTFS",
            "Description":"Fixed drive",
            "Volume":"\\\\?\\Volume{8fb7fea7-0000-0000-0000-100000000000}\\",
            "TotalInodes":-1,
            "TotalSpace":104853504,
            "FreeInodes":-1,
            "LogicalVolume":"",
            "UUID":"8fb7fea7-0000-0000-0000-100000000000",
            "Mountpoint":"E:\\",
            "Name":"Lokale Festplatte (E:)"
         },
         {
            "UsableSpace":58616619008,
            "Type":"NTFS",
            "Description":"Fixed drive",
            "Volume":"\\\\?\\Volume{c796c957-6485-44f5-a7f9-156021393b0a}\\",
            "TotalInodes":-1,
            "TotalSpace":248531996672,
            "FreeInodes":-1,
            "LogicalVolume":"",
            "UUID":"c796c957-6485-44f5-a7f9-156021393b0a",
            "Mountpoint":"C:\\",
            "Name":"Lokale Festplatte (C:)"
         },
         {
            "UsableSpace":309130682368,
            "Type":"NTFS",
            "Description":"Fixed drive",
            "Volume":"\\\\?\\Volume{8fb7fea7-0000-0000-0006-10837c000000}\\",
            "TotalInodes":-1,
            "TotalSpace":1465621508096,
            "FreeInodes":-1,
            "LogicalVolume":"",
            "UUID":"8fb7fea7-0000-0000-0006-10837c000000",
            "Mountpoint":"G:\\",
            "Name":"Lokale Festplatte (G:)"
         }
      ],
      "Disks":[
         {
            "Serial":"0025_3852_71B1_0E9E.",
            "Partitions":[
               {
                  "Type":"GPT: Unbekannt",
                  "Major":2,
                  "Uuid":"",
                  "Size":523239424,
                  "Identification":"Datenträgernr. 2, Partitionsnr. 0",
                  "Minor":0,
                  "Mountpoint":"",
                  "Name":"GPT: Unknown"
               },
               {
                  "Type":"GPT: System",
                  "Major":2,
                  "Uuid":"",
                  "Size":104857600,
                  "Identification":"Datenträgernr. 2, Partitionsnr. 1",
                  "Minor":1,
                  "Mountpoint":"",
                  "Name":"GPT: System"
               },
               {
                  "Type":"GPT: Standarddaten",
                  "Major":2,
                  "Uuid":"c796c957-6485-44f5-a7f9-156021393b0a",
                  "Size":248531999744,
                  "Identification":"Datenträgernr. 2, Partitionsnr. 2",
                  "Minor":2,
                  "Mountpoint":"C:\\",
                  "Name":"GPT: Basic Data"
               },
               {
                  "Type":"GPT: Unbekannt",
                  "Major":2,
                  "Uuid":"",
                  "Size":879755264,
                  "Identification":"Datenträgernr. 2, Partitionsnr. 3",
                  "Minor":3,
                  "Mountpoint":"",
                  "Name":"GPT: Unknown"
               }
            ],
            "Size":250056737280,
            "CurrentQueueLength":0,
            "Model":"Samsung SSD 960 EVO 250GB (Standardlaufwerke)",
            "Writes":1061243,
            "ReadBytes":34184769024,
            "Timestamp":1560176793787,
            "WriteBytes":80962136064,
            "Name":"\\\\.\\PHYSICALDRIVE2",
            "Reads":1317621,
            "TransferTime":1560175908389
         },
         {
            "Serial":"            5YD4BT6H",
            "Partitions":[
               {
                  "Type":"Installierbares Dateisystem",
                  "Major":1,
                  "Uuid":"8fb7fea7-0000-0000-0000-100000000000",
                  "Size":104857600,
                  "Identification":"Datenträgernr. 1, Partitionsnr. 0",
                  "Minor":0,
                  "Mountpoint":"E:\\",
                  "Name":"Installable File System"
               },
               {
                  "Type":"Installierbares Dateisystem",
                  "Major":1,
                  "Uuid":"8fb7fea7-0000-0000-0006-10837c000000",
                  "Size":1465621511168,
                  "Identification":"Datenträgernr. 1, Partitionsnr. 1",
                  "Minor":1,
                  "Mountpoint":"G:\\",
                  "Name":"Installable File System"
               },
               {
                  "Type":"Erweiterte Partition",
                  "Major":1,
                  "Uuid":"",
                  "Size":534666806272,
                  "Identification":"Datenträgernr. 1, Partitionsnr. 2",
                  "Minor":2,
                  "Mountpoint":"",
                  "Name":"Extended Partition"
               }
            ],
            "Size":2000396321280,
            "CurrentQueueLength":0,
            "Model":"ST2000DL003-9VT166 (Standardlaufwerke)",
            "Writes":22,
            "ReadBytes":11179058176,
            "Timestamp":1560176793787,
            "WriteBytes":90112,
            "Name":"\\\\.\\PHYSICALDRIVE1",
            "Reads":12802,
            "TransferTime":1560176597432
         },
         {
            "Serial":"        1347095BE306",
            "Partitions":[
               {
                  "Type":"Installierbares Dateisystem",
                  "Major":0,
                  "Uuid":"539f0ce6-0000-0000-0000-100000000000",
                  "Size":480102055936,
                  "Identification":"Datenträgernr. 0, Partitionsnr. 0",
                  "Minor":0,
                  "Mountpoint":"D:\\",
                  "Name":"Installable File System"
               }
            ],
            "Size":480101368320,
            "CurrentQueueLength":0,
            "Model":"Crucial_CT480M500SSD1 (Standardlaufwerke)",
            "Writes":47024,
            "ReadBytes":72555112448,
            "Timestamp":1560176793787,
            "WriteBytes":38024187904,
            "Name":"\\\\.\\PHYSICALDRIVE0",
            "Reads":801835,
            "TransferTime":1560176124447
         }
      ]
   }
}
```