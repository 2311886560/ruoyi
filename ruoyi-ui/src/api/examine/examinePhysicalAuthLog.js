import request from '@/utils/request'

// 查询数据审核记录列表
export function listExaminePhysicalAuthLog(query) {
  return request({
    url: '/system/examinePhysicalAuthLog/list',
    method: 'get',
    params: query
  })
}

// 查询数据审核记录详细
export function getExaminePhysicalAuthLog(id) {
  return request({
    url: '/system/examinePhysicalAuthLog/' + id,
    method: 'get'
  })
}

// 新增数据审核记录
export function addExaminePhysicalAuthLog(data) {
  return request({
    url: '/system/examinePhysicalAuthLog',
    method: 'post',
    data: data
  })
}

// 修改数据审核记录
export function updateExaminePhysicalAuthLog(data) {
  return request({
    url: '/system/examinePhysicalAuthLog',
    method: 'put',
    data: data
  })
}

// 删除数据审核记录
export function delExaminePhysicalAuthLog(id) {
  return request({
    url: '/system/examinePhysicalAuthLog/' + id,
    method: 'delete'
  })
}
