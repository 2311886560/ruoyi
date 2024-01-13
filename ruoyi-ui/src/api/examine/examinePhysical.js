import request from '@/utils/request'

// 查询数据信息列表
export function listExaminePhysical(query) {
  return request({
    url: '/system/examinePhysical/list',
    method: 'get',
    params: query
  })
}

// 查询数据信息详细
export function getExaminePhysical(id) {
  return request({
    url: '/system/examinePhysical/' + id,
    method: 'get'
  })
}

// 新增数据信息
export function addExaminePhysical(data) {
  return request({
    url: '/system/examinePhysical',
    method: 'post',
    data: data
  })
}

// 修改数据信息
export function updateExaminePhysical(data) {
  return request({
    url: '/system/examinePhysical',
    method: 'put',
    data: data
  })
}

// 删除数据信息
export function delExaminePhysical(id) {
  return request({
    url: '/system/examinePhysical/' + id,
    method: 'delete'
  })
}
