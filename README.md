# 医院WEB项目(后端源码)
## 框架与工具
SSM + MySql + Maven + Tomcat

## 功能实现
### 用户模块
1. 注册/登录
2. 查找医生
3. 创建预约
4. 查看预约状态
5. 取消预约
6. ...

### 医生模块
1. 注册/登录
2. 查看/编辑个人信息
3. 查看预约用户列表
4. 操作预约用户列表
5. ...

## 三、数据表结构
### 用户表(users)  
| uID | uName | uPwd | uTel |
| --- | --- | --- | --- |

### 医生表(doctors)
| dID | dPwd | dName | departmentID(科室ID) | dTel | date | introduction |
| --- | --- | --- | --- | --- | --- | --- |

### 科室表(departments)
| departmentID(科室ID) | departmentName(科室名) |
| --- | --- |

### 预约单表(appointments)
| appointmentID(预约id) | uID | dID | date |
| --- | --- | --- | --- |
