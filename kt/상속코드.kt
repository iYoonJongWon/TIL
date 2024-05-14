package com.example.mbti

open class Mbti(
    open var name: String
){
    open fun introduce() {
        println("저는 $name 입니다")
    }
    open fun introduce(char1 : String, char2: String) {
        println("저는 ${char1}과 ${char2}를 가지고 있습니다 ")
    }

}


class Analysts : Mbti(name = "분석가") {
    override fun introduce() {
        super.introduce()
    }
}

class Diplomats : Mbti(name = "외교관") {
    override fun introduce() {
        super.introduce()
    }
}

class Sentinels : Mbti(name = "관리자") {
    override fun introduce() {
        super.introduce()
    }
}

class Explorers : Mbti(name = "탐험가") {
    override fun introduce() {
        super.introduce()
    }
}

val person1 = Analysts()
val person2 = Diplomats()
val person3 = Sentinels()
val person4 = Explorers()

person1.introduce()
person1.introduce("직관형","사고형")
person2.introduce()
person2.introduce("직관형","감정형")
person3.introduce()
person3.introduce("감각형","판단형")
person4.introduce()
person4.introduce("감각형","인식형")
