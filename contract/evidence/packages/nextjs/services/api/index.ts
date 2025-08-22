import axios from "axios";

// 创建axios实例
const api = axios.create({
  baseURL: process.env.NEXT_PUBLIC_API_URL || "http://localhost:8080/api",
  headers: {
    "Content-Type": "application/json",
  },
});

// 请求拦截器 - 添加认证token
api.interceptors.request.use(
  (config) => {
    const token = localStorage.getItem("token");
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

// 响应拦截器 - 处理认证错误
api.interceptors.response.use(
  (response) => response,
  (error) => {
    if (error.response?.status === 401) {
      // 未授权，清除token并重定向到登录页
      localStorage.removeItem("token");
      window.location.href = "/auth/login";
    }
    return Promise.reject(error);
  }
);

/**
 * 用户登录
 * @param username 用户名
 * @param password 密码
 * @returns 登录响应
 */
export const loginUser = async (username: string, password: string) => {
  try {
    const response = await api.post("/auth/login", {
      username,
      password,
    });
    return response.data;
  } catch (error) {
    console.error("Login API error:", error);
    throw error;
  }
};

/**
 * 用户注册
 * @param username 用户名
 * @param password 密码
 * @param email 邮箱
 * @returns 注册响应
 */
export const registerUser = async (username: string, password: string, email: string) => {
  try {
    const response = await api.post("/auth/register", {
      username,
      password,
      email,
    });
    return response.data;
  } catch (error) {
    console.error("Register API error:", error);
    throw error;
  }
};

/**
 * 获取当前用户信息
 * @returns 用户信息
 */
export const getCurrentUser = async () => {
  try {
    const response = await api.get("/auth/me");
    return response.data;
  } catch (error) {
    console.error("Get current user API error:", error);
    throw error;
  }
};

export default api;