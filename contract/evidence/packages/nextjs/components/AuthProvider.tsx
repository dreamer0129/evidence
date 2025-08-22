"use client";

import { useEffect } from "react";
import { useAuthStore } from "~~/services/store/authStore";
import { getCurrentUser } from "~~/services/api";

interface AuthProviderProps {
  children: React.ReactNode;
}

const AuthProvider: React.FC<AuthProviderProps> = ({ children }) => {
  const { setUser, isAuthenticated } = useAuthStore();

  // 初始化认证状态
  useEffect(() => {
    const initializeAuth = async () => {
      const token = localStorage.getItem("token");
      if (token && !isAuthenticated) {
        try {
          // 验证token并获取用户信息
          const response = await getCurrentUser();
          if (response.success) {
            setUser(response.data);
          } else {
            // token无效，清除本地存储
            localStorage.removeItem("token");
          }
        } catch (error) {
          console.error("Failed to initialize auth:", error);
          // 发生错误，清除本地存储
          localStorage.removeItem("token");
        }
      }
    };

    initializeAuth();
  }, [isAuthenticated, setUser]);

  return <>{children}</>;
};

export default AuthProvider;