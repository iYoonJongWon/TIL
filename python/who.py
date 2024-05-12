#파일 불러오기
!gdown 1-Ycs1v25s_Mbt18mqpes9pHVZAI1vQ9D
!unzip /content/who.zip -d who

#데이터 지정
import pandas as pd
df = pd.read_csv('who/Life Expectancy Data.csv')
df

#데이터 결측치, 분포 확인
print(df.shape)
print(df.isnull().sum())
print(df.info())
print(df.head())
print(df.describe())


#데이터 전처리 및 분석

#Status의 숫자화 Status는 0은 개발중인나라 1 발전된 나라
df['Status'] = (df['Status'] == 'Developed').astype(int)

# 변수 이름의 띄어쓰기를 언더스코어(_)로 바꾸기
df = df.rename(columns=lambda x: x.replace(' ', '_'))

# 결과 확인
print(df.head())


import seaborn as sns
import matplotlib.pyplot as plt

#결측치 제거
df = df.dropna()

# 수치형 변수만 선택
numeric_columns = df.select_dtypes(include='number')

# 상관 행렬 계산
correlation_matrix = numeric_columns.corr()

# 히트맵 그리기
plt.figure(figsize=(10, 8))
sns.heatmap(correlation_matrix, annot=True, cmap='coolwarm', fmt=".2f")
plt.title("Correlation Heatmap of Numeric Variables")
plt.show()

import itertools
import statsmodels.api as sm
import numpy as np

# 종속 변수와 독립 변수 설정
y = df['Life_expectancy_']
X = df.drop(['Life_expectancy_','Country', 'Year'], axis=1)


#단계적 회귀 수행
import statsmodels.api as sm


def stepwise_selection(X, y):
    initial_features = X.columns.tolist()
    best_features = []
    while (len(initial_features) > 0):
        remaining_features = list(set(initial_features) - set(best_features))
        new_pval = pd.Series(index=remaining_features)
        for new_column in remaining_features:
            model = sm.OLS(y, sm.add_constant(pd.DataFrame(X[best_features + [new_column]]))).fit()
            new_pval[new_column] = model.pvalues[new_column]
        min_p_value = new_pval.min()
        if(min_p_value < 0.05):
            best_features.append(new_pval.idxmin())
        else:
            break
    return best_features

# 단계적 회귀 수행
selected_features = stepwise_selection(X, y)

# 선택된 변수 출력
print("Selected Features:", selected_features)

# 선택된 변수로 회귀 분석 수행
X_selected = X[selected_features]
X_selected = sm.add_constant(X_selected)
model = sm.OLS(y, X_selected).fit()

# 회귀 분석 결과 출력
print(model.summary())


from statsmodels.stats.outliers_influence import variance_inflation_factor

# 독립 변수들을 위한 VIF 계산
vif_data = sm.add_constant(X)
vif_series = pd.Series([variance_inflation_factor(vif_data.values, i) for i in range(vif_data.shape[1])], index=vif_data.columns)

print("VIF:")
print(vif_series)

X = X.drop(columns=['under-five_deaths_', 'GDP'])



#다중공선성 2개 제거하여 변수 12개 --> 10개로 바뀌는거 확인
def stepwise_selection(X, y):
    initial_features = X.columns.tolist()
    best_features = []
    while (len(initial_features) > 0):
        remaining_features = list(set(initial_features) - set(best_features))
        new_pval = pd.Series(index=remaining_features)
        for new_column in remaining_features:
            model = sm.OLS(y, sm.add_constant(pd.DataFrame(X[best_features + [new_column]]))).fit()
            new_pval[new_column] = model.pvalues[new_column]
        min_p_value = new_pval.min()
        if(min_p_value < 0.05):
            best_features.append(new_pval.idxmin())
        else:
            break
    return best_features

# 단계적 회귀 수행
selected_features = stepwise_selection(X, y)

# 선택된 변수 출력
print("Selected Features:", selected_features)

# 선택된 변수로 회귀 분석 수행
X_selected = X[selected_features]
X_selected = sm.add_constant(X_selected)
model = sm.OLS(y, X_selected).fit()

# 회귀 분석 결과 출력
print(model.summary())

#훈련 실험 세트 분할
from sklearn.model_selection import train_test_split
# 데이터를 훈련 세트와 테스트 세트로 분할합니다.
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42,shuffle= True)

# 훈련 데이터와 테스트 데이터의 크기를 확인합니다.
print("훈련 데이터의 크기:", X_train.shape)
print("테스트 데이터의 크기:", X_test.shape)

from sklearn.datasets import make_regression
from sklearn.ensemble import RandomForestRegressor
from sklearn.svm import SVR
from sklearn.linear_model import LinearRegression
from sklearn.metrics import mean_squared_error, r2_score
from sklearn.model_selection import train_test_split



# 각 모델 결정계수, 오차 확인
# 랜덤 포레스트 회귀 모델 생성 및 학습
rf_regressor = RandomForestRegressor(random_state=42)
rf_regressor.fit(X_train, y_train)
rf_y_pred = rf_regressor.predict(X_test)
rf_mse = mean_squared_error(y_test, rf_y_pred)
rf_r2 = r2_score(y_test, rf_y_pred)

# 서포트 벡터 머신 회귀 모델 생성 및 학습
svm_regressor = SVR()
svm_regressor.fit(X_train, y_train)
svm_y_pred = svm_regressor.predict(X_test)
svm_mse = mean_squared_error(y_test, svm_y_pred)
svm_r2 = r2_score(y_test, svm_y_pred)

# 선형 회귀 모델 생성 및 학습
linear_regressor = LinearRegression()
linear_regressor.fit(X_train, y_train)
linear_y_pred = linear_regressor.predict(X_test)
linear_mse = mean_squared_error(y_test, linear_y_pred)
linear_r2 = r2_score(y_test, linear_y_pred)

print("랜덤 포레스트 회귀 모델의 MSE:", rf_mse)
print("랜덤 포레스트 회귀 모델의 결정 계수(R^2):", rf_r2)
print("서포트 벡터 머신 회귀 모델의 MSE:", svm_mse)
print("서포트 벡터 머신 회귀 모델의 결정 계수(R^2):", svm_r2)
print("선형 회귀 모델의 MSE:", linear_mse)
print("선형 회귀 모델의 결정 계수(R^2):", linear_r2)

# 랜덤 포레스트 회귀 모델 생성 및 학습
rf_regressor = RandomForestRegressor(random_state=42)
rf_regressor.fit(X_train, y_train)

# 테스트 세트를 사용하여 예측 수행
y_pred = rf_regressor.predict(X_test)

# MSE 및 R^2 계산
mse = mean_squared_error(y_test, y_pred)
r_squared = r2_score(y_test, y_pred)

print("랜덤 포레스트 회귀 모델의 MSE:", mse)
print("랜덤 포레스트 회귀 모델의 결정 계수(R^2):", r_squared)


import pandas as pd

# 예측값과 실제값을 저장할 리스트를 생성합니다.
predictions = []
true_values = []

# 각 샘플에 대한 예측값과 실제값을 리스트에 저장합니다.
for i in range(25):
    # 테스트 세트의 i번째 샘플을 가져옵니다.
    test_sample = X_test.iloc[[i]]

    # 모델을 사용하여 예측을 수행합니다.
    prediction = rf_regressor.predict(test_sample)

    # 해당 테스트 샘플의 실제 값
    true_value = y_test.iloc[i]

    predictions.append(prediction[0])
    true_values.append(true_value)

# 리스트를 이용하여 DataFrame을 생성합니다.
df = pd.DataFrame({'예측값': predictions, '실제값': true_values})

# DataFrame을 출력합니다.
print(df)
