"use client";

import type { NextPage } from "next";

const VerifyEvidencePage: NextPage = () => {
  return (
    <div className="container mx-auto px-4 py-8">
      <div className="text-center mb-8">
        <h1 className="text-3xl font-bold mb-4">存证验证</h1>
        <p className="text-lg text-gray-600">验证文件或存证记录的真实性和完整性</p>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-3 gap-6 max-w-6xl mx-auto">
        <div className="card bg-base-100 shadow-xl">
          <div className="card-body">
            <h2 className="card-title text-primary mb-4">文件验证</h2>
            <p className="mb-4 text-sm">上传文件验证其哈希值是否与区块链记录一致</p>
            <div className="card-actions justify-center">
              <button className="btn btn-primary btn-wide" disabled>
                上传验证文件
              </button>
            </div>
          </div>
        </div>

        <div className="card bg-base-100 shadow-xl">
          <div className="card-body">
            <h2 className="card-title text-secondary mb-4">哈希验证</h2>
            <p className="mb-4 text-sm">输入文件哈希值验证其在区块链上的存在性</p>
            <div className="form-control">
              <input type="text" placeholder="输入哈希值" className="input input-bordered input-sm" disabled />
            </div>
            <div className="card-actions justify-center mt-4">
              <button className="btn btn-secondary btn-wide" disabled>
                验证哈希
              </button>
            </div>
          </div>
        </div>

        <div className="card bg-base-100 shadow-xl">
          <div className="card-body">
            <h2 className="card-title text-accent mb-4">存证编号验证</h2>
            <p className="mb-4 text-sm">通过存证编号查询和验证完整的存证记录</p>
            <div className="form-control">
              <input type="text" placeholder="输入存证编号" className="input input-bordered input-sm" disabled />
            </div>
            <div className="card-actions justify-center mt-4">
              <button className="btn btn-accent btn-wide" disabled>
                查询验证
              </button>
            </div>
          </div>
        </div>
      </div>

      <div className="mt-12 text-center">
        <div className="alert alert-info max-w-2xl mx-auto">
          <div>
            <span>功能开发中...</span>
            <p className="text-sm mt-2">验证功能正在积极开发中，即将上线</p>
          </div>
        </div>

        <div className="stats shadow bg-base-100 mt-8 max-w-2xl mx-auto">
          <div className="stat">
            <div className="stat-title">验证方式</div>
            <div className="stat-value">3种</div>
            <div className="stat-desc">文件/哈希/编号验证</div>
          </div>

          <div className="stat">
            <div className="stat-title">区块链查询</div>
            <div className="stat-value text-success">实时</div>
            <div className="stat-desc">直接查询链上数据</div>
          </div>

          <div className="stat">
            <div className="stat-title">验证报告</div>
            <div className="stat-value">PDF</div>
            <div className="stat-desc">完整验证报告生成</div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default VerifyEvidencePage;
