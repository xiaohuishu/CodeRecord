#!/bin/bash

# ------------------------------------------------------------
# 每天凌晨12点对/tmp/download/目录下hive查询的结果文件进行清理
# crontab -l 查看当前系统 自动化脚本
# sudo vim crontab -e
# 将脚本加入操作系统的crontab 中，直接VI加入即可
#-------------------------------------------------------------

# hive查询结果文件
DOWNLOAD_DIR='/tmp/download'

# 判断'/tmp/download'目录是否存在并且其是否存在*.txt 查询结果文件

if [ -d $DOWNLOAD_DIR  ]; then
    cd $DOWNLOAD_DIR
    pwd
    echo "check $DOWNLOAD_DIR files and start clean..."
    FILE=$(ls -1 $DOWNLOAD_DIR | grep -v default)
    if [ "$FILE" != ""  ] ; then
        for i in $(ls -1 $DOWNLOAD_DIR | grep -v default)
        do
            echo $i
            if [ -f $DOWNLOAD_DIR/$i  ]; then
                rm -rf $DOWNLOAD_DIR/$i
            fi
        done
    else
        echo "$DOWNLOAD_DIR not exist *.txt"
    fi
else
    echo "Can't enter $DOWNLOAD_DIR"
fi
echo "cleaned up ..."
exit 0
