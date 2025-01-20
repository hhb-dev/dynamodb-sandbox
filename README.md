# 目的

本repositoryはdynamoDBの学習のために好き勝手するやつです。\
READMEにはそのノウハウ的なことを書きます。

# めも

## AWS SDK for Java

DynamoDBをspringboot（java）で使用するためのSDKは公式から提供されている。\
https://docs.aws.amazon.com/sdk-for-java/ \
現時点ではv2（[github repo](https://github.com/aws/aws-sdk-java-v2)）が出ており、これが推奨される。\
ChatGPTに聞くとしれっとv1のコードが出たりするので要注意。

v2（DynamoDB関係）は
1. software.amazon.awssdk:dynamodb
2. software.amazon.awssdk:dynamodb-enhanced

がパッケージングされている。[参考: mvn DynamoDB Clients](https://mvnrepository.com/open-source/dynamodb-clients?p=1)\
比較は下記より

| **ライブラリ**                                  | **特徴**                                | **使う場面**                          |
|--------------------------------------------|---------------------------------------|-----------------------------------|
| `software.amazon.awssdk:dynamodb`          | 低レベルAPI、フルコントロールが可能。冗長なコードになりやすい。     | 高度なカスタマイズが必要な場合や特殊な操作を行う場合。       |
| `software.amazon.awssdk:dynamodb-enhanced` | 高レベルAPI、簡潔なコード。Javaオブジェクトとしてデータを操作可能。 | 開発効率を重視し、標準的なCRUD操作がメインのアプリケーション。 |

### 概要図
(![dynamoDB_x_awsSDK_overview.png](https://docs.aws.amazon.com/images/amazondynamodb/latest/developerguide/images/SDKSupport.png))

## local環境でのDynamoDB操作

考え方として2パターンがある。
1. dockerでDynamoDBイメージを起動して接続
2. aws上で構築したDynamoDBに接続

aws公式だと2が推奨。（理由：1でできない操作があるから）\
ただし、基本的な操作は1でもできるため開発スタイルに応じてまずは決めても良いと思う。

### 1の詳細

公式の[こちら](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)
を参照して[compose.yml](./compose.yml)を作成。

注）dynamodb-initはawsのconfigをdocker上で設定するための追加している。\
　　local端末でaws-cliを使用しているとすでにaws configがあるためdynamodb-initをしなくとも動く。\
　　開発メンバー間で動く・動かない等があればまずはここを疑ったほうが良い。

