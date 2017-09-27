/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 * @flow
 */
import 'whatwg-fetch';
import React, { Component } from 'react';
import {
    AppRegistry,
    StyleSheet,
    PixelRatio,
    Text,
    Navigator,
    Image,
    ListView,
    ScrollView,
    View,
    Alert,
    TouchableHighlight
    } from 'react-native';

class AwesomeProject extends Component {
    render() {
        let defaultName='GoListNavigator';
        let defaultComponent=GoListNavigator;
        return (
            <Navigator
                initialRoute={{ name: defaultName, component: defaultComponent }}
                //配置场景
                configureScene=
                    {
                        (route) => {

                             //跳转动画
                            return Navigator.SceneConfigs.VerticalDownSwipeJump;
                         }
                     }
                renderScene={
            (route, navigator) =>
             {
            let Component = route.component;
            return <Component {...route.params} navigator={navigator} />
          }
          } />


        );
    }
}

class GoListNavigator extends Component {

    constructor(props) {
        super(props);
        this.state = {

        };
    }

    onFunction(){
             const { navigator } = this.props;
            //获取跳转navigator
            if(navigator) {
                //指定跳转的页面，传参
                navigator.push({
                    name: 'List',
                    component: List,
                })
            }
    }
    //主界面
    render() {
        return (
            <View style={styles.flex}>

                <View style={styles.topView} >
                    <TouchableHighlight onPress={()=>this.onFunction()}>
                    <Image
                        resizeMode="contain"
                        source={require('./img/top.png')}
                        />
                        </TouchableHighlight>
                </View>

                <View style={styles.container}>

                    <View style={[styles.item,styles.center]}>

                        <View style={styles.imgview }>
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex} >
                                <Text style={styles.font}>我的待办</Text>
                            </View>
                        </View>



                    </View>


                    <View style={[styles.item,styles.center,styles.lineLeftRight]}>
                        <View style={styles.imgview} >
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex}>
                                <Text style={styles.font}>我的请求</Text>
                            </View>
                        </View>
                    </View>



                    <View style={[styles.item,styles.center,styles.lineLeftRight]}>
                        <View style={styles.imgview} >
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex}>
                                <Text style={styles.font}>站内消息</Text>
                            </View>
                        </View>
                    </View>
                </View>

                <View style={styles.separate}>
                </View>



                <View style={{height:20,borderBottomWidth:1/PixelRatio.get(),borderColor:'#242924',backgroundColor:'#FFFFFF'}}>
                    <Text style={{fontsize:10}}>常用模块</Text>
                </View>



                <View style={styles.module}>

                    <View style={[styles.item,styles.center]}>

                        <View style={styles.imgview}>
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex} >
                                <Text style={styles.font}>我的待办</Text>
                            </View>
                        </View>



                    </View>


                    <View style={[styles.item,styles.center,styles.lineLeftRight]}>
                        <View style={styles.imgview} >
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex}>
                                <Text style={styles.font}>我的请求</Text>
                            </View>
                        </View>
                    </View>



                    <View style={[styles.item,styles.center,styles.lineLeftRight]}>
                        <View style={styles.imgview} >
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex}>
                                <Text style={styles.font}>站内消息</Text>
                            </View>
                        </View>
                    </View>
                    <View style={[styles.item,styles.center,styles.lineLeftRight]}>
                        <View style={styles.imgview} >
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex}>
                                <Text style={styles.font}>站内消息</Text>
                            </View>
                        </View>
                    </View>
                </View>


                <View style={styles.module}>

                    <View style={[styles.item,styles.center]}>

                        <View style={styles.imgview}>
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex} >
                                <Text style={styles.font}>我的待办</Text>
                            </View>
                        </View>



                    </View>


                    <View style={[styles.item,styles.center,styles.lineLeftRight]}>
                        <View style={styles.imgview} >
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex}>
                                <Text style={styles.font}>我的请求</Text>
                            </View>
                        </View>
                    </View>



                    <View style={[styles.item,styles.center,styles.lineLeftRight]}>
                        <View style={styles.imgview} >
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex}>
                                <Text style={styles.font}>站内消息</Text>
                            </View>
                        </View>
                    </View>
                    <View style={[styles.item,styles.center,styles.lineLeftRight]}>
                        <View style={styles.imgview} >
                            <Image style={styles.img}
                                   resizeMode="contain"
                                   source={{uri:'http://m.tiebaimg.com/timg?wapp&quality=80&size=b150_150&subsize=20480&cut_x=0&cut_w=0&cut_y=0&cut_h=0&sec=1369815402&srctrace&di=638e11be4aa18febd9524a8bf281b0d6&wh_rate=null&src=http%3A%2F%2Fimgsrc.baidu.com%2Fforum%2Fpic%2Fitem%2F94cad1c8a786c917cb87664ccf3d70cf3bc7573a.jpg'}}
                                />
                            <View style={styles.flex}>
                                <Text style={styles.font}>站内消息</Text>
                            </View>
                        </View>
                    </View>
                </View>

            </View>
        );
    }
}

class List extends Component{

    constructor(props) {
        super(props);
        this.state = {
            dataSource:new ListView.DataSource({
                rowHasChanged:(row1,row2)=> row1 !== row2,
            }),
        };
    }

    _pressButton() {
    const { navigator } = this.props;
    if(navigator) {
        navigator.pop();//使上个页面出栈
    }
}



    //组件加载完成后的方法
    componentDidMount() {
        this.dsfetchData();
    }

    dsfetchData(){
        //获取数据
        var _this=this;
        var resouse;
        fetch('http://58.218.213.113:8880/mcoa/mobile/bpm/bpmMobileTask/pendingMatters.ht?userId=1', {
             method: 'POST',
             headers: {
             'Accept': 'application/json',
             'Content-Type': 'application/json',
         },
            //userId:'10000031472995'
             body: JSON.stringify({
                 userId: '1',
                 })
         })
         .then(function(response){
                 return response.json();
         })
         .then(function(json){

         resouse=json.results;;

             _this.setState({
                 dataSource: _this.state.dataSource.cloneWithRows(resouse),
             })

         })
         .catch(function(err){
            Alert.alert('error',err.toString());
         })

    }

    itemView(item) {
        return (
                <View >
                    <Text>{item.subject}</Text>
                </View>
        );
    }


    render(){
        return(
            <ListView
                dataSource={this.state.dataSource}
                renderRow={this.itemView}
                />
        );
    }

}



const styles = StyleSheet.create({

    module:{
        marginLeft:5,
        marginRight:5,
        height:80,
        flexDirection:'row',
        backgroundColor:'#FFFFFF',
        borderBottomWidth:1/PixelRatio.get(),
        borderColor:'#BEBEBE',
    },
    topView:{
        flexDirection:'row',
    },
    imgview:{
        flex:2,
    },

    img:{
        marginTop:10,
        width: 40,
        height: 40,
        borderRadius:20,
    },
    container: {
        marginLeft:5,
        marginRight:5,
        height:100,
        flexDirection:'row',
        borderRadius:5,
        padding:2,
        backgroundColor:'#FFFFFF',
    },
    item: {
        flex: 1,
        height:80,

    },
    center:{
        justifyContent:'center',
        alignItems:'center',
    },
    flex:{
        flex:1,
    },
    font:{
        marginTop:10,
        color:'#BEBEBE',
        fontSize:10,
        fontWeight:'bold',

    },
    lineLeftRight:{
        borderLeftWidth:0.6/PixelRatio.get(),
        borderColor:'#BEBEBE',
    },
    separate:{
        height:13,
        backgroundColor:'#eff0f0',
        borderBottomWidth:1/PixelRatio.get(),
        borderTopWidth:1/PixelRatio.get(),
        borderColor:'#242924',
    },
    lineCenter:{
        borderBottomWidth:1/PixelRatio.get(),
        borderColor:'#BEBEBE',
    },
    center:{
        justifyContent:'center',
        alignItems:'center',
    },
});

AppRegistry.registerComponent('AwesomeProject', () => AwesomeProject);
