<template>
    <div v-if="msg.type === 'TEXT'" style="white-space: pre-wrap;">
        {{ msg.content }}
    </div>
    <template v-else-if="msg.type === 'IMAGE'">
        <el-image :src="`${fileBaseUrl}/${msg.content}`" fit="cover" style="width: auto; height: auto;" lazy>
        </el-image>
    </template>
    <template v-else-if="msg.type === 'FILE'">
        <div>
            <template v-if="self">
                <el-link :href="`${fileBaseUrl}/${msg.content}`" fit="cover"
                    style="width: auto; height: auto; color: #E4E7ED; border-bottom: 1px solid" lazy type="warning"
                    target="_blank">
                    <el-icon style="margin-right: 5px;">
                        <Folder />
                    </el-icon>
                    {{ msg.content }}
                </el-link>
            </template>
            <template v-else>
                <el-link :href="`${fileBaseUrl}/${msg.content}`" fit="cover" style="width: auto; height: auto; " lazy
                    type="primary" target="_blank">
                    <el-icon style="margin-right: 5px;">
                        <Folder />
                    </el-icon>
                    {{ msg.content }}
                </el-link>
            </template>
        </div>
    </template>
    <template v-else-if="msg.type === 'LINK'">
        <div>
            <template v-if="self">
                <el-link :href="`${msg.content}`" fit="cover"
                    style="width: auto; height: auto; color: #E4E7ED; border-bottom: 1px solid" lazy type="warning"
                    target="_blank">
                    {{ msg.content }}
                </el-link>
            </template>
            <template v-else>
                <el-link :href="`${msg.content}`" fit="cover" style="width: auto; height: auto; " lazy type="primary"
                    target="_blank">
                    {{ msg.content }}
                </el-link>
            </template>
        </div>
    </template>
    <div v-else>
        [暂不支持此消息类型-{{ msg.type }}]
    </div>
</template>

<script setup>
import { fileBaseUrl } from '@/config/UrlConfig';
/**
 * 根据不同type
 * 渲染msg
 */
const props = defineProps(['msg', 'self'])
</script>


<style></style>