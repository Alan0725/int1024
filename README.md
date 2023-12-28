通用规约
---

[阿里巴巴Java开发手册](http://www.xingqiji.com/index.php?mod=pdf&path=UU55cE52bkFUSnJpTWJPTGgxSDJmQVpQZ3RGZl9jS05PWWp3Z3o5T3ZEYm1wbFlPQ0ttMkxEblhVMTczYS1Sd0NqMWltbWNBek9Md0V3)

### 结构组织

```
src
│
├── main
│   ├── java
│   │   └── com
│   │       ├── common
│   │       │   └── ... (通用代码)
│   │       │
│   │       └── int1024
│   │           └── tail (小尾巴)
│   │               ├── config
│   │               │   └── ... (配置类)
│   │               ├── controller
│   │               │   └── ... (控制器类)
│   │               ├── service
│   │               │   ├── impl
│   │               │   │   └── ... (服务实现类)
│   │               │   └── ... (服务接口)
│   │               ├── repository
│   │               │   ├── cache
│   │               │   │   └── ... (缓存层)
│   │               │   └── mapper
│   │               │       └── ... (数据访问层)
│   │               ├── model
│   │               │   └── ... (数据模型和实体类)
│   │               └── ...
│   │
│   └── resources
│       ├── application.properties (或 application.yml)
│       ├── static
│       │   └── ... (静态资源文件)
│       ├── templates
│       │   └── ... (模板文件，如果使用模板引擎)
│       └── ...
│
└── test
    ├── java
    │   └── com
    │       └── int1024
    │           └── ... (测试类)
    │
    └── resources
        └── ... (测试资源文件)

```
