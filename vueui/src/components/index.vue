<template>
  <div class="layout">
    <Layout :style="{minHeight: '100vh'}">
      <Sider
        collapsible
        :collapsed-width="0"
        default-collapsed
        v-model="isCollapsed">
        <Card style="width:100%;height:10%;background-color: white;">
          <Icon type="ios-water" size="30"/>SeaFile
        </Card>
        <Menu :theme="theme2" style="width:100%;" :accordion="accordion">
          <Submenu name="1">
            <template slot="title">
              <Icon type="ios-navigate"></Icon>
              Item 1
            </template>
            <MenuItem name="1-1">Option 1</MenuItem>
            <MenuItem name="1-2">Option 2</MenuItem>
            <MenuItem name="1-3">Option 3</MenuItem>
          </Submenu>
          <Submenu name="2">
            <template slot="title">
              <Icon type="ios-keypad"></Icon>
              Item 2
            </template>
            <MenuItem name="2-1">Option 1</MenuItem>
            <MenuItem name="2-2">Option 2</MenuItem>
          </Submenu>
          <Submenu name="3">
            <template slot="title">
              <Icon type="ios-analytics"></Icon>
              Item 3
            </template>
            <MenuItem name="3-1">Option 1</MenuItem>
            <MenuItem name="3-2">Option 2</MenuItem>
          </Submenu>
        </Menu>
      </Sider>
      <Layout style="width:80%;height:100%;">
        <Content class="content">
          <!--<component v-bind:is="$store.state.main.contentView"></component>-->
        </Content>
      </Layout>
    </Layout>
  </div>
</template>
<script>
  export default {
    name: 'index',
    data () {
      return {
        isCollapsed: false,
        theme2: 'dark',
        accordion:true,
      }
    },
    computed:{
      menuitemClasses: function () {
        return [
          'menu-item',
          this.isCollapsed ? 'collapsed-menu' : ''
        ]
      }
    },
    methods:{
      toPage(type){
        console.log("toPage:"+type);
      },
    }
  }
</script>
<style scoped>
  .layout{
    width:100%;
    height:100%;
  }
  .sider{
    background-color: #808695;
    width:20%;
    height:100%;
  }
  .content{
    background-color: #dcdee2;
    height:75%;
  }
  .layout-con{
    height: 100%;
    width: 100%;
  }
  .menu-item span{
    display: inline-block;
    overflow: hidden;
    width: 69px;
    text-overflow: ellipsis;
    white-space: nowrap;
    vertical-align: bottom;
    transition: width .2s ease .2s;
  }
  .menu-item i{
    transform: translateX(0px);
    transition: font-size .2s ease, transform .2s ease;
    vertical-align: middle;
    font-size: 16px;
  }
  .collapsed-menu span{
    width: 0px;
    transition: width .2s ease;
  }
  .collapsed-menu i{
    transform: translateX(5px);
    transition: font-size .2s ease .2s, transform .2s ease .2s;
    vertical-align: middle;
    font-size: 22px;
  }
</style>
