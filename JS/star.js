let output = "";
let size = 15;
for(let i = 1; i <= size; i++){
    for(let j = 15; j > i; j--){
        output += " ";
    }
    for(let k = 0; k < 2 * i - 1; k++){
        output += "*";
    }

    output += "\n";
}

console.log(output);