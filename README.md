# ScrollBanner
一个用法类似ListView 且性能高于ViewPager的滚动banner

## 前言

项目的来源初衷是在公司的项目中接到一个实际需求，需要一个在顶部上下滚动的Banner。Banner,就算通常APP里轮播的广告。



OK，看到这个东西第一时间想到的实现方案就是ViewPager，很简单的嘛。虽然是要上下滚动，和ViewPager的功能不太相同，但垂直的ViewPager应该有的吧？搜一下~我的天，重写ViewPager，还那么一大堆代码……，自己想办法吧！（有兴趣的可以搜一下，垂直滚动的ViewPager）


## 优势

先讲一下ScrollBanner的优势在哪里，总要先忽悠住你用的嘛。

- **性能高于ViewPager**

- **用法类似于ListView**



#### 性能高于ViewPager

ViewPager的性能瓶颈在于，为了更通用，每一个界面都是新创建的，10个不同的界面可能就有10个View的存在，当然可以通过配置，使得ViewPager同一时间只存在3个View。但3个似乎也有点多（因为同一时间最多只有两个View同时显示），而View得创建于销毁也是有开销的。

下面是ScrollBanner的吹牛逼时间：

**同一时间只有两个View存在** ScrollBanner因为业务需求的限制，所以View存在高度的相似性，且并没有过度的交互，所以同一时间至多只有两个View存在。

**ScrollBanner采用data binding策略，不存在View的创建销毁开销** 一直都是在对两个View进行复用（缺点是，同一组Banner的view样式是要想同的，但既然是一组Banner，View样式就应该相同啊）

**ScrollBanner的自动滚动策略利用了Handler的消息延迟发送** 弃用了传统的线程控制，Handler的好处是不存在线程的创建开销。但因Message的收发完全解耦，控制存在隐患，不过以解决（卖个关子，详情看代码哦~）

#### 类似ListView的用法

其实就我本人来说，对使用开源控件的热度并不大。其中一个原因就是，**学习使用成本！**

1.当做一个黑盒子用，文档写得好还行，文档写得懵懵懂懂……~热门控件网上有教程，那一些偏冷的，真的需要耗费很长时间去学习使用和踩坑，而这个“学习”的过程，对你知识增长是很少的。（比较你是在学怎么开车，而不是车的运行原理）

2.当一个白盒使用，读源码吧亲。柯柯~


**所以，简易的用法绝对是每一个开源控件最应该遵循的原则！！**

**而在简易用法之上，是熟悉的用法！！ScrollBanner就是！ScrollBanner就是！！**

ScrollBanner的用法完全类似Listview，通过adapter创建View。看下示例你就懂了：

布局文件添加：

	    <com.zhaoxuan.scrollbanner.ScrollBanner
        	android:id="@+id/scrollBanner"
        	android:layout_width="match_parent"
        	android:layout_height="40dp"
        	app:orientation="vertical"   //自动垂直滚动或水平滚动
        	android:visibility="gone" />
        	

View初始化：

	ScrollBanner scrollBanner = (ScrollBanner) findViewById(R.id.scrollBanner);
	

数据源初始化

	//BannerDto就是简单的JavaBean
	bannerDtos = new ArrayList<>();
    bannerDtos.add(new BannerDto(1, "#FF34B3", 1, "1111111 : 5s", 1, 5000));
    bannerDtos.add(new BannerDto(2, "#EE6A50", 2, "2222222 : 3s", 1, 3000));
    bannerDtos.add(new BannerDto(3, "#B3EE3A", 3, "3333333 : 4s", 1, 4000));
    
    
适配器初始化

	//ScrollBanner提供了抽象Adapter，需要自己实现
	bannerAdapter = new BannerAdapter(this);
    bannerAdapter.setDatas(bannerDtos);

	//为scrollBanner设置adapter
    scrollBanner.setAdapter(bannerAdapter);
    
滚动

	//自动滚动
	scrollBanner.start();
	//停止自动滚动
	scrollBanner.stop();
	//固定在某个banner
	scrollBanner.fixBanner(2);
	//隐藏Banner
	scrollBanner.hideCustomBanner();
	//手动下一个
	scrollBanner.next();
	//以垂直或水平方向下一个
	scrollBanner.nextOfModel(ScrollBanner.ORIENTATION_HORIZONTAL);
	
	
Adapter的实现完全类似ListView的Adapter，只是添加了一些额外方法，[详情看代码哦](https://github.com/lizhaoxuan/ScrollBanner/blob/master/app/src/main/java/com/zhaoxuan/demo/BannerAdapter.java)~


### 怎么样，用法真的和ListView极其类似吧，是不是毫无陌生感？





