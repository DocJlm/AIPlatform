import { defineStore } from 'pinia'
import { ref } from 'vue'
import { getLoginUser, userLogout } from '@/api/userController.ts'
import { message } from 'ant-design-vue'

export const useLoginUserStore = defineStore('loginUser', () => {
  // 默认值
  const loginUser = ref<API.LoginUserVO>({
    userName: '未登录',
  })

  // 获取登录用户信息
  async function fetchLoginUser() {
    const res = await getLoginUser()
    if (res.data.code === 0 && res.data.data) {
      loginUser.value = res.data.data
    }
  }
  // 更新登录用户信息
  function setLoginUser(newLoginUser: any) {
    loginUser.value = newLoginUser
  }

  // 用户注销
  async function logout() {
    const res = await userLogout()
    if (res.data.code === 0) {
      loginUser.value = {
        userName: '未登录',
      }
      message.success('退出登录成功')
    } else {
      message.error('退出登录失败，' + res.data.message)
    }
  }

  return { loginUser, setLoginUser, fetchLoginUser, logout }
})
