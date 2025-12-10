const fs = require('fs');
const path = require('path');

// 获取项目根目录
const projectRoot = path.resolve(__dirname, '.');

// 模板配置文件路径
const templateConfigPath = path.join(projectRoot, 'template.json');

/**
 * 读取目录信息并生成模板配置
 */
function generateTemplateInfo() {
  console.log('正在生成模板信息...');

  // 读取现有的模板配置
  let templateConfig = {};
  if (fs.existsSync(templateConfigPath)) {
    const templateConfigContent = fs.readFileSync(templateConfigPath, 'utf8');
    templateConfig = JSON.parse(templateConfigContent);
  }

  // 获取所有模板目录
  const templateDirs = fs.readdirSync(projectRoot, { withFileTypes: true })
    .filter(dirent => dirent.isDirectory() && !dirent.name.startsWith('.') && dirent.name !== 'scripts')
    .map(dirent => dirent.name);

  console.log('找到模板目录:', templateDirs);

  // 为每个模板目录生成信息
  templateDirs.forEach(dir => {
    const templatePath = path.join(projectRoot, dir);
    const packageJsonPath = path.join(templatePath, 'package.json');

    // 默认模板信息
    const templateInfo = {
      name: dir,
      description: '',
    };

    // 如果存在 package.json，读取其中的信息
    if (fs.existsSync(packageJsonPath)) {
      try {
        const packageJson = JSON.parse(fs.readFileSync(packageJsonPath, 'utf8'));
        templateInfo.name = dir;
        templateInfo.description = packageJson.description || '';

      } catch (err) {
        console.warn(`读取 ${dir}/package.json 时出错:`, err.message);
      }
    }

    // 如果是中文名称，尝试翻译成英文作为 key
    const key = dir.toLowerCase().replace(/\s+/g, '-');
    templateConfig[key] = templateInfo;
  });

  // 写入模板配置文件
  fs.writeFileSync(templateConfigPath, JSON.stringify(templateConfig, null, 2));
  console.log('模板信息生成完成!');
}

// 执行脚本
generateTemplateInfo();
