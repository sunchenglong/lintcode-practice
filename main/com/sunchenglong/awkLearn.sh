#!/usr/bin/env bash
awk -F"\t" 'BEGIN{
//开始执行一次
e = 0.0001
}
{
    //每行处理一次
    if(FILENAME==ARGV[1]){
    //处理第一个文件
    }else if(FILENAME==ARGV[2]){
    //处理第二个文件
        if($1==$2) {
            //第一列等于第二列执行 nop
        }else if((($1-$2)>0)?($1-$2):($2-$1) < e){
            //第一列与第二列的绝对值小于e执行
            result1[$1] = $2
            //result1为一个map key为第1列的值，value是第2列
            result2[$1$2] = $3
            //result2为一个map key为第1列与第2列拼起来的值，value是第3列
            if(FNR == 50){
                print $0
            //打印这个文件的第50行
            }
        }else if(NR == 50){
            //打印已经读出的第50行
        }
    }
}
END{
//最后执行一次
    //遍历一result2这个map
    for(key in result2){
        printf("Thekey is %s, the value is %s", key, result1[key])
    }
}' inputFile1 inputFile2 > outputFile