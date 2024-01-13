import request from '@/utils/request'

// 查询医院信息列表
export function listHospital(query) {
  return request({
    url: '/system/hospital/list',
    method: 'get',
    params: query
  })
}

// 查询医院信息详细
export function getHospital(id) {
  return request({
    url: '/system/hospital/' + id,
    method: 'get'
  })
}

// 新增医院信息
export function addHospital(data) {
  return request({
    url: '/system/hospital',
    method: 'post',
    data: data
  })
}

// 修改医院信息
export function updateHospital(data) {
  return request({
    url: '/system/hospital',
    method: 'put',
    data: data
  })
}

// 删除医院信息
export function delHospital(id) {
  return request({
    url: '/system/hospital/' + id,
    method: 'delete'
  })
}
