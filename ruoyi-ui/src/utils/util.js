/**
 * 通用方法
 */

/**
 * 限制只能输入数字(可以输入两位小数)
 * @returns {number}
 * @param val
 */
export function limitNumber(val) {
  let value = null
  value = String(val).replace(/[^\d.]/g, '') // 清除“数字”和“.”以外的字符
  value = value.replace(/\.{2,}/g, '.') // 只保留第一个. 清除多余的
  value = value.replace('.', '$#$').replace(/\./g, '').replace('$#$', '.')
  value = value.replace(/^(-)*(\d+)\.(\d\d).*$/, '$1$2.$3') // 只能输入两个小数
  return Number(value)
}

/**
 * 限制只能输入数字(整数)
 * @returns {number}
 * @param val
 */
export function integerNum(val) {
  debugger
  if (val === 0 || val === '0' || val === '') {
    return '1';
  }
  let value = null
  value = String(val).replace(/[^\d]/g, '') // 清除“数字”和“.”以外的字符
  if (value==0){
    return 1;
  }
  return Number(value)
}

/**
 * 实时限制只能输入数字(可以输入两位小数)
 * @returns {number}
 * @param val
 */
export function formatNumber(value) {
  return value.replace(/[^\d^\.?]+/g, "").replace(/^0+(\d)/, "$1").replace(/^\./, "0.").match(/^\d*(\.?\d{0,2})/g)[0] || "";
}

/**
 * 实时限制只能输入数字(可以输入三位小数)
 * @returns {number}
 * @param val
 */
export function formatNumberThird(value) {
  return value.replace(/[^\d^\.?]+/g, "").replace(/^0+(\d)/, "$1").replace(/^\./, "0.").match(/^\d*(\.?\d{0,3})/g)[0] || "";
}

/**
 * 限制多位小数的输入
 * @param value
 * @returns {string}
 */
export function formatNumberFour(value) {
  return value.replace(/[^\d^\.?]+/g, "").replace(/^0+(\d)/, "$1").replace(/^\./, "0.").match(/^\d*(\.?\d{0,4})/g)[0] || "";
}


/**
 * 限制只能输入数字(可以输入两位小数)
 * @param oldVal
 * @returns {number}
 */
export function limitZeroNumber(val) {
  if (val === 0 || val === '0' || val === '') {
    return ''
  } else {
    let value = String(val).replace(/[^\d.]/g, '') // 清除“数字”和“.”以外的字符
    value = value.replace(/\.{2,}/g, '.') // 只保留第一个. 清除多余的
    value = value.replace('.', '$#$').replace(/\./g, '').replace('$#$', '.')
    value = value.replace(/^(-)*(\d+)\.(\d\d).*$/, '$1$2.$3') // 只能输入两个小数
    return Number(value)
  }
}

export function deepClone(target) {
  // 定义一个变量
  let result;
  // 如果当前需要深拷贝的是一个对象的话
  if (typeof target === 'object') {
    // 如果是一个数组的话
    if (Array.isArray(target)) {
      result = []; // 将result赋值为一个数组，并且执行遍历
      for (let i in target) {
        // 递归克隆数组中的每一项
        result.push(deepClone(target[i]))
      }
      // 判断如果当前的值是null的话；直接赋值为null
    } else if (target === null) {
      result = null;
      // 判断如果当前的值是一个RegExp对象的话，直接赋值
    } else if (target.constructor === RegExp) {
      result = target;
    } else {
      // 否则是普通对象，直接for in循环，递归赋值对象的所有值
      result = {};
      for (let i in target) {
        result[i] = deepClone(target[i]);
      }
    }
    // 如果不是对象的话，就是基本数据类型，那么直接赋值
  } else {
    result = target;
  }
  // 返回最终结果
  return result;
}

//通过value获取Label list格式:[{ label: p.dictLabel, value: p.dictValue}]
export function getLabel(value,list=[]) {
  let res ='-';
  list.forEach(e=>{
    if(e.value == value){
      res = e.label;
    }
  })
  return res;
}

/**
 * 两个时间比较
 * @param startDate
 * @param endDate
 */
export function compareDate(startDate,endDate){
  if(startDate != null && endDate != null){
    try{
      var start = new Date(startDate);
      var end = new Date(endDate);
      if(start.getTime() > end.getTime()){
        return true;
      }
    } catch (e) {}
  }
  return false;
}
