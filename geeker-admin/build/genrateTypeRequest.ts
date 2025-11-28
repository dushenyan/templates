import fs from 'node:fs';
import path from 'node:path';
import os from 'node:os';
import { pipeline } from 'node:stream/promises';
import axios from 'axios';
import AdmZip from 'adm-zip';

const SOURCE_URL = 'http://localhost:8080/ts.zip';
const GENERATE_DIR = 'src/__generated';

(async () => {
  try {
    // 1. 清理旧目录
    if (fs.existsSync(GENERATE_DIR)) {
      fs.rmSync(GENERATE_DIR, { recursive: true, force: true });
    }

    // 2. 下载文件
    const tmpFile = path.join(os.tmpdir(), `ts-${Date.now()}.zip`);
    const writer = fs.createWriteStream(tmpFile);
    const resp = await axios.get(SOURCE_URL, { responseType: 'stream' });
    await pipeline(resp.data, writer);

    // 3. 解压
    new AdmZip(tmpFile).extractAllTo(GENERATE_DIR, true);

    // 4. 清理临时文件
    fs.unlinkSync(tmpFile);

    console.log('✅ 类型请求已成功生成.');
  } catch (e) {
    console.error('❌ 生成类型请求失败:', e);
    process.exit(1);
  }
})();
