package com.atguigu.springcloud.filter;

/**
 * @className: MyLogGateWayFilter
 * @description:
 * @author: liusCoding
 * @create: 2020-06-08 22:43
 */

//@Component
//@Slf4j
//public class MyLogGateWayFilter implements GlobalFilter, Ordered
//{
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain)
//    {
//        log.info("***********come in MyLogGateWayFilter:  "+new Date());
//
//        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
//
//        if(uname == null)
//        {
//            log.info("*******用户名为null，非法用户，o(╥﹏╥)o");
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            return exchange.getResponse().setComplete();
//        }
//
//        return chain.filter(exchange);
//    }
//
//    @Override
//    public int getOrder()
//    {
//        return 0;
//    }
//}

