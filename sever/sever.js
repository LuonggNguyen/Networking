var exports = module.exports;
exports.result = (name,score) => {
    return `Name: ${name}   Score: ${score}`
}
exports.hinhhoc = (dai,rong) => {
    return `Dien Tich ${dai*rong}   Chu Vi: ${dai+rong}`
}
exports.thetich = (canh) => {
    return `The Tich ${canh*canh*canh}`
}
exports.ptb2 = (a,b,c) => {
    let delta = (b*b-4*a*c)
    if(delta < 0){
        return 'Phuong trinh vo nghiem'
    }
    if(delta === 0){
        return `Phuong trinh co nghiem kep x1 = x2 = ${-b/(2*a)}`
    }
    if(delta > 0){
        return `Phuong trinh co 2 nghiem kep x1 =${(-b-Math.sqrt(delta))/(2*a)}   x2 =${(-b+Math.sqrt(delta))/(2*a)}`
    }
}