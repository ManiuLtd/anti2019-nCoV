#!/usr/bin/env bash

echo "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
echo "[INFO]开始更新代码......"
echo "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"

git pull


echo "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"
echo "[INFO]开始Maven打包......"
echo "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"


mvn clean package -Dmaven.test.skip=true

if [ $? -ne 0 ]; then
    echo ""
    echo "***********************************************************"
    echo "[INFO]Maven打包失败"
    echo "***********************************************************"
    exit 1
fi
rm -rf output
mkdir output
cp ./target/antincov-donation-biz*.jar output/
rm -rf jsondata
mkdir jsondata
python3 get_json.py
cp control.sh output/
chmod 744 output/control.sh
if [ $? -ne 0 ]; then
    echo ""
    echo "***********************************************************"
    echo "[INFO]移动打包文件失败"
    echo "***********************************************************"
    exit 1
fi
echo ""
echo "***********************************************************"
echo "[INFO]Maven打包成功!!!!"
echo "***********************************************************"
