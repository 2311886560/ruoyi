import request from '@/utils/request'

// 查询项列表
export function listExamineItem(query) {
  return request({
    url: '/system/examineItem/list',
    method: 'get',
    params: query
  })
}

// 查询项详细
export function getExamineItem(id) {
  return request({
    url: '/system/examineItem/' + id,
    method: 'get'
  })
}

// 新增项
export function addExamineItem(data) {
  return request({
    url: '/system/examineItem',
    method: 'post',
    data: data
  })
}

// 修改项
export function updateExamineItem(data) {
  return request({
    url: '/system/examineItem',
    method: 'put',
    data: data
  })
}

// 删除项
export function delExamineItem(id) {
  return request({
    url: '/system/examineItem/' + id,
    method: 'delete'
  })
}
