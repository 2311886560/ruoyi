import request from '@/utils/request'

// 查询数据明细列表
export function listExaminePhysicalDetail(query) {
  return request({
    url: '/system/examinePhysicalDetail/list',
    method: 'get',
    params: query
  })
}

// 查询数据明细详细
export function getExaminePhysicalDetail(id) {
  return request({
    url: '/system/examinePhysicalDetail/' + id,
    method: 'get'
  })
}

// 新增数据明细
export function addExaminePhysicalDetail(data) {
  return request({
    url: '/system/examinePhysicalDetail',
    method: 'post',
    data: data
  })
}

// 修改数据明细
export function updateExaminePhysicalDetail(data) {
  return request({
    url: '/system/examinePhysicalDetail',
    method: 'put',
    data: data
  })
}

// 删除数据明细
export function delExaminePhysicalDetail(id) {
  return request({
    url: '/system/examinePhysicalDetail/' + id,
    method: 'delete'
  })
}
