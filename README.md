# FriendsNotebook
Android Clean Architecture的简易demo
# Android Clean Architecture
一种基于mvp的架构（其实应用在mvc, mvvm也是可以的）的加强架构，有框架独立，UI独立，易于测试等等特点。关于此架构的更多知识，参见Uncle Bob的文章：[The Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html)
# 层次结构
项目的层次结构：
## data
包内包含了整个项目中的用到的基础bean，扩展了[LitePal](https://github.com/LitePalFramework/LitePal)里面的DataSupport类，属于“洋葱”的最里层。
## repository
定义了数据查询的基本操作，属于第二层。
## domain
其中包含了一系列UseCase（命名为Task），属于第三层。
## presenter
View用到的Presenter类，调用调度器来完成Task的回调。
## view
基本展现层，只写了两个功能，但是足以说明如何使用。