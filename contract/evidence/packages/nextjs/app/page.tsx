"use client";

import Link from "next/link";
import type { NextPage } from "next";
import { useAccount } from "wagmi";
import { DocumentDuplicateIcon, DocumentMagnifyingGlassIcon } from "@heroicons/react/24/outline";
import { Address } from "~~/components/scaffold-eth";

const Home: NextPage = () => {
  const { address: connectedAddress } = useAccount();

  return (
    <>
      <div className="flex items-center flex-col grow pt-10">
        <div className="px-5">
          <h1 className="text-center">
            <span className="block text-2xl mb-2">欢迎使用</span>
            <span className="block text-4xl font-bold">区块链存证系统</span>
          </h1>
          <div className="flex justify-center items-center space-x-2 flex-col">
            <p className="my-2 font-medium">已连接地址:</p>
            <Address address={connectedAddress} />
          </div>

          <p className="text-center text-lg mt-4">基于区块链技术的电子数据存证与验证平台</p>
        </div>

        <div className="grow bg-base-300 w-full mt-16 px-8 py-12">
          <div className="flex justify-center items-center gap-12 flex-col md:flex-row">
            <div className="flex flex-col bg-base-100 px-10 py-10 text-center items-center max-w-xs rounded-3xl hover:shadow-lg transition-shadow">
              <DocumentDuplicateIcon className="h-12 w-12 text-primary mb-4" />
              <h3 className="text-xl font-bold mb-2">文件存证</h3>
              <p className="mb-4 text-sm">上传文件或文件哈希值，将数据永久记录在区块链上</p>
              <Link href="/evidence/create" className="btn btn-primary btn-sm">
                开始存证
              </Link>
            </div>

            <div className="flex flex-col bg-base-100 px-10 py-10 text-center items-center max-w-xs rounded-3xl hover:shadow-lg transition-shadow">
              <DocumentMagnifyingGlassIcon className="h-12 w-12 text-primary mb-4" />
              <h3 className="text-xl font-bold mb-2">存证验证</h3>
              <p className="mb-4 text-sm">验证文件或哈希值的真实性，获取完整的验证报告</p>
              <Link href="/evidence/verify" className="btn btn-primary btn-sm">
                开始验证
              </Link>
            </div>
          </div>

          <div className="mt-12 text-center">
            <div className="stats shadow bg-base-100">
              <div className="stat">
                <div className="stat-title">区块链网络</div>
                <div className="stat-value text-primary">以太坊</div>
                <div className="stat-desc">不可篡改 · 永久存储</div>
              </div>

              <div className="stat">
                <div className="stat-title">支持算法</div>
                <div className="stat-value text-secondary">SHA256</div>
                <div className="stat-desc">安全哈希 · 标准认证</div>
              </div>

              <div className="stat">
                <div className="stat-title">法律效力</div>
                <div className="stat-value">合规</div>
                <div className="stat-desc">符合电子证据规范</div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
