"use client";

import { useState } from "react";
import Link from "next/link";
import { useRouter } from "next/navigation";
import { registerUser } from "@/services/api";
import { Alert, Button, Form, Input } from "antd";
import { ArrowRightIcon, EnvelopeIcon, LockClosedIcon, UserIcon } from "@heroicons/react/24/outline";

const RegisterPage = () => {
  const [form] = Form.useForm();
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [success, setSuccess] = useState<string | null>(null);
  const router = useRouter();

  const handleSubmit = async (values: { username: string; password: string; email: string }) => {
    setLoading(true);
    setError(null);
    setSuccess(null);

    try {
      const response = await registerUser(values.username, values.password, values.email);
      if (response.success) {
        setSuccess("注册成功，请登录");
        // 重置表单
        form.resetFields();
        // 延迟跳转到登录页
        setTimeout(() => {
          router.push("/auth/login");
        }, 2000);
      } else {
        setError(response.message || "注册失败");
      }
    } catch (err: any) {
      // 显示具体的错误消息，而不是通用的网络错误
      setError(err.message || "网络错误，请稍后再试");
      console.error("Register error:", err);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="min-h-screen bg-gray-50 flex items-center justify-center p-4">
      <div className="w-full max-w-md bg-white rounded-lg shadow-md overflow-hidden">
        <div className="p-6 bg-gradient-to-br from-green-600 to-teal-700 text-white">
          <h2 className="text-2xl font-bold text-center">区块链存证系统</h2>
          <p className="text-center mt-2 opacity-90">用户注册</p>
        </div>
        <div className="p-6">
          {error && <Alert message="注册失败" description={error} type="error" showIcon className="mb-4" />}

          {success && <Alert message="注册成功" description={success} type="success" showIcon className="mb-4" />}

          <Form form={form} onFinish={handleSubmit} layout="vertical" className="space-y-4">
            <Form.Item
              name="username"
              label="用户名"
              rules={[
                { required: true, message: "请输入用户名" },
                { min: 3, message: "用户名长度不能少于3个字符" },
                { max: 20, message: "用户名长度不能超过20个字符" },
              ]}
            >
              <Input prefix={<UserIcon className="h-5 w-5 text-gray-400" />} placeholder="请输入用户名" />
            </Form.Item>

            <Form.Item
              name="email"
              label="邮箱"
              rules={[
                { required: true, message: "请输入邮箱" },
                { type: "email", message: "请输入有效的邮箱地址" },
              ]}
            >
              <Input prefix={<EnvelopeIcon className="h-5 w-5 text-gray-400" />} placeholder="请输入邮箱" />
            </Form.Item>

            <Form.Item
              name="password"
              label="密码"
              rules={[
                { required: true, message: "请输入密码" },
                { min: 6, message: "密码长度不能少于6个字符" },
                { max: 20, message: "密码长度不能超过20个字符" },
              ]}
            >
              <Input.Password prefix={<LockClosedIcon className="h-5 w-5 text-gray-400" />} placeholder="请输入密码" />
            </Form.Item>

            <Form.Item>
              <Button
                type="primary"
                htmlType="submit"
                loading={loading}
                className="w-full bg-green-600 hover:bg-green-700 text-white py-3 rounded-lg"
                icon={<ArrowRightIcon className="ml-2 h-4 w-4" />}
                size="large"
              >
                注册
              </Button>
            </Form.Item>
          </Form>

          <div className="mt-6 text-center">
            <p>
              已有账号？
              <Link href="/auth/login" className="text-green-600 hover:underline ml-1">
                立即登录
              </Link>
            </p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RegisterPage;
