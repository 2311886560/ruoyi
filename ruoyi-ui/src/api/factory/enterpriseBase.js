import request from '@/utils/request'

// 查询工厂基本信息列表
export function listEnterpriseBase(query) {
  return request({
    url: '/factory/enterpriseBase/list',
    method: 'get',
    params: query
  })
}

// 查询工厂基本信息详细
export function getEnterpriseBase(id) {
  return request({
    url: '/factory/enterpriseBase/' + id,
    method: 'get'
  })
}

// 新增工厂基本信息
export function addEnterpriseBase(data) {
  return request({
    url: '/factory/enterpriseBase',
    method: 'post',
    data: data
  })
}

// 修改工厂基本信息
export function updateEnterpriseBase(data) {
  return request({
    url: '/factory/enterpriseBase',
    method: 'put',
    data: data
  })
}

// 删除工厂基本信息
export function delEnterpriseBase(id) {
  return request({
    url: '/factory/enterpriseBase/' + id,
    method: 'delete'
  })
}
