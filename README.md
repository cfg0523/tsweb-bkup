# tsweb

Techsen Core Web Project

目的：
    建构Techsen公司基础的平台性质的项目，期望实现将公司内所有人开发的Java项目
    融合成一个项目，当有新的需求来时，只需要在此项目的基础上开发新的模块即可。
    期望能够做到可插拔式的项目设计。

模块：
    tsweb(pom): 所有子项目的父项目，统一管理子项目的依赖关系
    tsweb-core(jar): 提供其他项目所依赖的常用工具，Entity，DAO，Service层的公共基类等
    tsweb-com(war): 提供WEB层的的公共资源(JSP, CSS, HTML, JS及其他带模板性质的文件等)
    tsweb-sys(war): 系统管理模块，实现权限拦截，事务，日志等系统级的任务
    tsweb-main(war): 聚合其他war项目，最终生成一个war包(即最终生成的产品)
    

