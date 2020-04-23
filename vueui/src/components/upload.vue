<template>
  <div style="width:100%;height:100%;">
    <Input v-model="path" placeholder="Enter the upload directory" style="width: 200px" />
    <Upload
      ref="upload"
      multiple
      type="drag"
      max-size=1048576000
      :before-upload="beforeUpload"
      :on-success="onSuccess"
      :on-error="onError"
      :on-exceeded-size="onExceededSize"
      :on-remove="onRemove"
      :data="params"
      action="http://localhost:8081/file/upload">
      <div style="padding: 20px 0">
        <Icon type="ios-cloud-upload" size="52" style="color: #3399ff"></Icon>
        <p>Click or drag files here to upload</p>
      </div>
    </Upload>
    <Button type="primary" @click="upload">上传</Button>
  </div>
</template>
<script>
    export default {
      name: "upload",
      data(){
          return{
            path:'',
            params:{},
            files:[],
          }
      },
      methods:{
        upload(){
          console.log(this.params)
          console.log(this.path)
          this.params.path=this.path
          console.log(this.$refs.upload)
          for(var i=0;i<this.files.length;i++) {
            this.$refs.upload.post(this.files[i])
          }
        },
        beforeUpload(file){
          console.log(file)
          this.files.push(file);
          return false;
        },
        onSuccess(response,file,fileList){
          console.log(response)
          console.log(file)
          console.log(fileList)
          this.$Message.info("上传成功!")
        },
        onError(error,file,fileList){
          this.$Message.error("上传失败!")
        },
        onExcceededSize(file,fileList){
          this.$Message.error("上传文件超过指定大小!")
        },
        onRemove(file,fileList){

        }
      }
    }
</script>

<style scoped>

</style>
