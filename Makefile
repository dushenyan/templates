# Emphasis 模板项目集合 Makefile

# 生成模板信息
.PHONY: generate-templates
generate-templates:
	@echo "正在生成模板信息..."
	node generate-template-info.js

# 提交前检查
.PHONY: precommit
g:
	@echo "生成模板信息别名..."
	node generate-template-info.js
	@echo "提交前检查完成!"

# 帮助信息
.PHONY: help
help:
	@echo "Emphasis 模板项目集合 Makefile"
	@echo ""
	@echo "可用命令:"
	@echo "  make generate-templates  - 生成模板信息"
	@echo "  make help                - 显示此帮助信息"

# 默认目标
.DEFAULT_GOAL := help
