import request from '@/utils/request'

// 查询干休所信息列表
export function listRetired(query) {
  return request({
    url: '/system/retired/list',
    method: 'get',
    params: query
  })
}

// 查询干休所信息详细
export function getRetired(id) {
  return request({
    url: '/system/retired/' + id,
    method: 'get'
  })
}

// 新增干休所信息
export function addRetired(data) {
  return request({
    url: '/system/retired',
    method: 'post',
    data: data
  })
}

// 修改干休所信息
export function updateRetired(data) {
  return request({
    url: '/system/retired',
    method: 'put',
    data: data
  })
}

// 删除干休所信息
export function delRetired(id) {
  return request({
    url: '/system/retired/' + id,
    method: 'delete'
  })
}
