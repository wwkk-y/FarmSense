<template>
    <div id="about">
        <h1>FarmSense</h1>
        <h2>起源</h2>
        <p>做为一个来自农村的学生，我对农业生产中的病虫害问题有着深刻的体会，所以我希望利用自己的专业知识，开发这个农业病虫害智能预警系统，帮助农民更有效地防范和应对病虫害。</p>
        <h2>目标</h2>
        <li>
            <span class="blod">基础平台搭建：</span>
            开发最基本的网页端功能
        </li>
        <li>
            <span class="blod">图像识别：</span>
            基于YOLOv5实现基于图片的病虫害智能识别，快速、准确地诊断问题。基于RPC框架Dubbo实现服务端跨语言调用
        </li>
        <li>
            <span class="blod">社区模块：</span>
            打造线上交流平台，用户可分享经验、讨论病虫害防治方法，形成知识共享与互助生态
        </li>
        <li>
            <span class="blod">搜索模块：</span>
            提供便捷的搜索功能，针对不同的病虫害给出科学、实用的解决方案。实现轻量搜索引擎，目前主流的ElasticSearch太重，对于服务器需求较高，考虑到成本问题，开发一个轻量级搜索引擎
        </li>
        <li>
            <span class="blod">数据可视化(扩展)：</span>
            根据历史信息做数据可视化分析，显示病虫害在不同地区，时间上的爆发程度
        </li>
        <div style="width: 100%; overflow: hidden">
            <img src="@/assets/111.png" style="width: 100%;"/>
        </div>
        <h2>项目信息</h2>
        <li>
            github: <a href="https://github.com/wwkk-y/FarmSense">https://github.com/wwkk-y/FarmSense</a>
        </li>
        <li>
            bug反馈: <a href="https://github.com/wwkk-y/FarmSense/issues">链接</a>
        </li>
        <li>
            联系方式：3262954152@qq.com
        </li>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
#about{
    padding-left: 10%;
    padding-right: 10%;
    /* text-align: center; */
}

#about>h1,
h2 {
    margin-top: 10px;
    margin-bottom: 10px;
}

.blod {
    font-weight: bold;
}
</style>