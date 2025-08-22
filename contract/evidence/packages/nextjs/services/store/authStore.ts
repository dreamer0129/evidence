import { create } from "zustand";

// 用户信息类型定义
interface User {
  id: number;
  username: string;
  email: string;
  role: string;
  createdAt: string;
  updatedAt: string;
}

// 认证状态类型定义
interface AuthState {
  user: User | null;
  isAuthenticated: boolean;
  setUser: (user: User | null) => void;
  logout: () => void;
}

// 创建认证状态存储
export const useAuthStore = create<AuthState>(set => ({
  user: null,
  isAuthenticated: false,
  setUser: (user: User | null) => {
    set({ 
      user,
      isAuthenticated: !!user
    });
  },
  logout: () => {
    // 清除本地存储的token
    localStorage.removeItem("token");
    // 重置用户状态
    set({ 
      user: null,
      isAuthenticated: false
    });
  }
}));

// 注意：认证状态初始化逻辑已移至AuthProvider组件中实现
// 请查看components/AuthProvider.tsx文件了解详情

export default useAuthStore;