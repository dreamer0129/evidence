"use client";

import { useState } from "react";
import Link from "next/link";
import { useRouter } from "next/navigation";
// 请先确保已安装 antd 依赖，可通过以下命令安装：npm install antd @types/antd
import { Button, Input, Alert, Form } from "antd";
import { LockClosedIcon, UserIcon, ArrowRightIcon } from '@heroicons/react/24/outline';

import { loginUser } from "@/services/api";
import { useAuthStore } from "@/services/store/authStore";

// 定义User类型
interface User {
  id: number;
  username: string;
  email: string;
  role: string;
  createdAt: string;
  updatedAt: string;
  [key: string]: any;
}

// 定义登录请求参数类型
interface LoginParams {
  username: string;
  password: string;
}

// 定义登录响应类型
interface LoginResponse {
  success: boolean;
  message?: string;
  data?: {
    token: string;
    user: User;
  };
}

const LoginPage = () => {
  const [form] = Form.useForm<LoginParams>();
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const router = useRouter();
  const { setUser } = useAuthStore();

  const handleSubmit = async (values: LoginParams) => {
    setLoading(true);
    setError(null);

    try {
      const response: LoginResponse = await loginUser(values.username, values.password);
      if (response.success && response.data) {
        const { token, user } = response.data;
        // 存储token和用户信息
        localStorage.setItem("token", token);
        setUser(user);
        // 重定向到首页
        router.push("/");
      } else {
        setError(response.message || "登录失败");
      }
    } catch (err) {
      setError(err instanceof Error ? err.message : "网络错误，请稍后再试");
      console.error("Login error:", err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen bg-gray-50 flex items-center justify-center p-4">
      <div className="w-full max-w-md bg-white rounded-lg shadow-md overflow-hidden">
        <div className="p-6 bg-gradient-to-br from-blue-600 to-indigo-700 text-white">
          <h2 className="text-2xl font-bold text-center" aria-label="区块链存证系统登录">区块链存证系统</h2>
          <p className="text-center mt-2 opacity-90">用户登录</p>
        </div>
        <div className="p-6">
          {error && (
            <Alert
              message="登录失败"
              description={error}
              type="error"
              showIcon
              className="mb-4"
              closable
            />)
          }

          <Form
              form={form}
              onFinish={handleSubmit}
              layout="vertical"
              className="space-y-4"
              aria-labelledby="login-form-title"
            >
              <Form.Item
                name="username"
                label="用户名"
                rules={[{ required: true, message: "请输入用户名" }]}
                hasFeedback
              >
                <Input
                  prefix={<UserIcon className="h-5 w-5 text-gray-400" />}
                  placeholder="请输入用户名"
                  aria-label="用户名"
                />
              </Form.Item>

              <Form.Item
                name="password"
                label="密码"
                rules={[{ required: true, message: "请输入密码" }]}
                hasFeedback
              >
                <Input.Password
                  prefix={<LockClosedIcon className="h-5 w-5 text-gray-400" />}
                  placeholder="请输入密码"
                  aria-label="密码"
                />
              </Form.Item>

              <Form.Item>
                <Button
                  type="primary"
                  htmlType="submit"
                  loading={loading}
                  block
                  icon={<ArrowRightIcon className="ml-2 h-4 w-4" />}
                  size="large"
                  aria-label="登录按钮"
                >
                  登录
                </Button>
              </Form.Item>
            </Form>

            <div className="mt-6 text-center">
              <p>还没有账号？
                <Link href="/auth/register" className="text-blue-600 hover:underline ml-1" aria-label="前往注册页面">
                  立即注册
                </Link>
              </p>
            </div>
        </div>
      </div>
    </div>
  );
};

export default LoginPage;