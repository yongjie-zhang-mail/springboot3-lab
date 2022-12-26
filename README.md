# SpringBoot 3.0 Lab

## 名称：

SpringBoot 3.0 Lab

## 沙漏状的框架：

底层原子服务层，粒度尽量细，可供上层灵活组合调用。

中层业务服务层，聚合各种原子服务，形成具体业务逻辑。

顶层对外接口层，接口尽量专项专用，通过中层业务服务的入参收口多态。

## maven 多模块项目

lab-common-model

通用模型

lab-common-service

通用服务，原子服务

lab-admin

lab-11

lab-22

业务服务

业务服务依赖 common-service，依赖 common-model；

代码根据复用程度，判断是否需要放在 common model 和 service 模块中；

业务服务垂直依赖 common 模块，业务服务之间水平没有依赖；






