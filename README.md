﻿# seniorprojects

## blend4webtemplate/
> เก็บไฟล์ที่เกี่ยวกับการใช้งาน blend4web

## indie-art-ubon/
> play project files

## ฟังก์ชันที่เหลือ
1. Downloadmodel file.blend

> ตรวจดู code ได้ที่  controllers/IndieApplication.upmodel , views/showmodel.scala.html 

> signup สมาชิกใหม่ จากนั้น upload model เลือก picture, blend, html submit

> เลือก model จากนั้น กดปุ่ม ฺBlend เพื่อ download blend model

2. Show Model

> เลือก Html เพื่อแสดง model บนเว็บ


##
>file forum.scala ในตัวโมเดล จะมี userID เพื่อจะเช็คว่าใครเป็นคน upกระทู้  แล้วหนูอยากได้ iduser ตอนทำการ login เข้าใช้งานระบบ 
	แต่ตอนนี้มันยัง ramdomid ให้ใหม่คะ เพราะหนุไม่รู้วิธีดึง id จากตาราง user มาใช้ในตาราง forum คะ  
Answer: 
1. ผู้ใช้ login 
2. ผู้ใช้ไปหน้าหลัก /
3. ผู้ใช้เลือก model ในส่วน 3D model แล้วกด watch
4. ผู้ใช้เขียน comment แล้ว กด send

Code: 
1. forms.CommentForm เพิ่ม field ชื่อ commenterID และปรับ Data ให้มี commenterID ด้วย
2. showmodel.scala.html บรรทัดที่ 37 เพิ่ม hidden field สำหรับเก็บ commenterID เป็น user.userID
3. controllers.IndieApplication.comment เอา data.commenterID ไปใช้ได้

	

