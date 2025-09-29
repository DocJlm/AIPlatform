<template>
  <a-layout-header class="header">
    <a-row :wrap="false" align="middle">
      <!-- 左侧：Logo和标题 -->
      <a-col flex="200px">
        <RouterLink to="/">
          <div class="header-left">
            <img class="logo" src="@/assets/logo.png" alt="Logo" />
            <h1 class="site-title">AI生成平台</h1>
          </div>
        </RouterLink>
      </a-col>
      <!-- 中间：导航菜单 -->
      <a-col flex="auto">
        <a-menu
          v-model:selectedKeys="selectedKeys"
          mode="horizontal"
          :items="menuItems"
          @click="handleMenuClick"
          class="header-menu"
        />
      </a-col>
      <!-- 右侧：用户操作区域 -->
      <a-col>
        <div class="user-login-status">
          <a-button type="primary">登录</a-button>
        </div>
      </a-col>
    </a-row>
  </a-layout-header>
</template>

<script setup lang="ts">
import { h, ref } from 'vue'
import { useRouter } from 'vue-router'
import type { MenuProps } from 'ant-design-vue'

const router = useRouter()
// 当前选中菜单
const selectedKeys = ref<string[]>(['/'])
// 监听路由变化，更新当前选中菜单
router.afterEach((to, from, next) => {
  selectedKeys.value = [to.path]
})

// 菜单配置项
const menuItems = ref([
  {
    key: '/',
    label: '首页',
    title: '首页',
  },
  {
    key: '/about',
    label: '关于',
    title: '关于我们',
  },
  {
    key: 'others',
    label: h('a', { href: 'https://www.zqcblog.com/', target: '_blank' }, '我的博客'),
    title: '我的博客',
  },
])

// 处理菜单点击
const handleMenuClick: MenuProps['onClick'] = (e) => {
  const key = e.key as string
  selectedKeys.value = [key]
  // 跳转到对应页面
  if (key.startsWith('/')) {
    router.push(key)
  }
}
</script>

<style scoped>
.header {
  background: #fff;
  padding: 0 24px;
  height: 64px;
  line-height: 64px;
  border-bottom: none;
  box-shadow: none;
}

.header-left {
  display: flex;
  align-items: center;
  gap: 12px;
  height: 64px;
}

.logo {
  height: 40px;
  width: 40px;
  border-radius: 50%;
}

.site-title {
  margin: 0;
  font-size: 18px;
  color: #1890ff;
  font-weight: 600;
  line-height: 64px;
}

.header-menu {
  border-bottom: none !important;
  line-height: 64px;
}

.user-login-status {
  display: flex;
  align-items: center;
  height: 64px;
}

/* 确保所有元素垂直居中对齐 */
.ant-row {
  height: 64px;
}

.ant-col {
  display: flex;
  align-items: center;
}
</style>
