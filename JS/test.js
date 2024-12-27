function min(first, ...rests) {
    let output;
    let items;

    if(Array.isArray(first)) {
        output = first[0];
        items = first;
    } else if (typeof first == 'number') {
        output = first;
        items = rests;
    }

    for(const item of items) {
        if(output > item) {
            output = item;
        }
    }
    return output;
}


console.log(`${min(10,8,2,4,5)}`);

arr = [5,2,6,4];

arr = arr.map(function(value) {
    return value*value;
});
arr.forEach(function (value,index,array){
    console.log(`${index}번째 요소 : ${value}, ${array}`);
});

arr.forEach(console.log);


let numbers = [0,1,2,3,4,5,6,7,8,9];

numbers
    .filter((value) => value % 2 === 0)
    .map((value) => value*value)
    .forEach((value) => {
        console.log(value);
    }
    )


const pet = {
    name : '구름',
    eat : function(food) {
        console.log(this.name + '는' + food + '를 먹는다.');
    }
}

pet.eat('밥');


const student = {};
student.name = "조성진";

console.log(JSON.stringify(student,null,2));