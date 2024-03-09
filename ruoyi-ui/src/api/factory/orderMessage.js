import request from '@/utils/request'

// 查询商品订单消息列表
export function listOrderMessage(query) {
  return request({
    url: '/factory/orderMessage/list',
    method: 'get',
    params: query
  })
}

// 查询商品订单消息详细
export function getOrderMessage(id) {
  return request({
    url: '/factory/orderMessage/' + id,
    method: 'get'
  })
}

// 新增商品订单消息
export function addOrderMessage(data) {
  return request({
    url: '/factory/orderMessage',
    method: 'post',
    data: data
  })
}

// 修改商品订单消息
export function updateOrderMessage(data) {
  return request({
    url: '/factory/orderMessage',
    method: 'put',
    data: data
  })
}

// 删除商品订单消息
export function delOrderMessage(id) {
  return request({
    url: '/factory/orderMessage/' + id,
    method: 'delete'
  })
}
