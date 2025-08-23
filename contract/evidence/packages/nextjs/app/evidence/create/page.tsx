"use client";

import type { NextPage } from "next";

const CreateEvidencePage: NextPage = () => {
  return (
    <div className="container mx-auto px-4 py-8">
      <div className="text-center mb-8">
        <h1 className="text-3xl font-bold mb-4">文件存证</h1>
        <p className="text-lg text-gray-600">上传文件或输入文件哈希值，将数据永久记录在区块链上</p>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-8 max-w-4xl mx-auto">
        <div className="card bg-base-100 shadow-xl">
          <div className="card-body">
            <h2 className="card-title text-primary mb-4">文件上传存证</h2>
            <p className="mb-4">直接上传您的文件，系统将自动计算哈希值并记录到区块链</p>
            <div className="card-actions justify-center">
              <button className="btn btn-primary btn-wide" disabled>
                选择文件
              </button>
            </div>
            <div className="text-xs text-gray-500 mt-2">支持格式: PDF, DOC, JPG, PNG 等 (最大 100MB)</div>
          </div>
        </div>

        <div className="card bg-base-100 shadow-xl">
          <div className="card-body">
            <h2 className="card-title text-secondary mb-4">哈希值存证</h2>
            <p className="mb-4">输入已计算好的文件哈希值，直接进行区块链存证</p>
            <div className="form-control">
              <label className="label">
                <span className="label-text">文件哈希值</span>
              </label>
              <input type="text" placeholder="输入 SHA256 哈希值" className="input input-bordered" disabled />
            </div>
            <div className="card-actions justify-center mt-4">
              <button className="btn btn-secondary btn-wide" disabled>
                提交存证
              </button>
            </div>
          </div>
        </div>
      </div>

      <div className="mt-12 text-center">
        <div className="alert alert-info max-w-2xl mx-auto">
          <div>
            <span>功能开发中...</span>
            <p className="text-sm mt-2">存证功能正在积极开发中，即将上线</p>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CreateEvidencePage;
