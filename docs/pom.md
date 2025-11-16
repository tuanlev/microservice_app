# QUẢN LÝ DEPENDENCIES CHO CÁC SERVICE
### Triển khai trong common-service (pattern)
```
<packaging>pom</packaging>
    <modules>
        <module>
        ../auth-service
    </module>
</modules>  
```

### Note: 
1. Những dependency được quản lý trong <Dependenies/> là những kế thừa các service con sẽ sử dụng không cần khai báo
2. <dependencyManagement/> là những abstract đã có sẵn version service con không cần khai báo version

### Triển khai trong service (pattern)
1. Thay đổi các thông số trong <Parent> thành của common-service và relativepath chiếu đến đường dẫn file pom đó

