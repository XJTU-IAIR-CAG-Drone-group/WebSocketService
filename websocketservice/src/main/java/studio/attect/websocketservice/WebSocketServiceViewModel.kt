package studio.attect.websocketservice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okio.ByteString

/**
 * WebSocketService与其它接口进行数据交换的ViewModel
 *
 * @author attect
 * @date 2019-05-04
 */
class WebSocketServiceViewModel :ViewModel(){
    /**
     * 接收到的字符串数据
     */
    val receiveStringData = MutableLiveData<String?>()

    /**
     * 接收到的二进制数据
     */
    val receiveBytesData = MutableLiveData<ByteString?>()

    /**
     * 要发送的字符串数据
     */
    val sendStringData = MutableLiveData<String?>()

    /**
     * 要发送的二进制数据
     */
    val sendBytesData = MutableLiveData<ByteString?>()


    /**
     * 给服务断开连接的信号
     * 注意不要将其内容设为null
     */
    val stopByUser = MutableLiveData<Boolean>()

    /**
     * 服务状态
     * 模糊的
     * 取值为null时，表示service没有启动
     */
    val status = MutableLiveData<WebSocketStatus>()

    /**
     * 外部使用时请求获取下一个文本数据
     * @see StringDataObserver.onChanged
     */
    internal fun requireNextStringData(){
        receiveStringData.value?.let {
            receiveStringData.postValue(null)
        }
    }

    /**
     * 外部使用时请求获取下一个二进制数据
     * @see BytesDataObserver.onChanged
     */
    internal fun requireNextBytesData(){
        receiveBytesData.value?.let {
            receiveBytesData.postValue(null)
        }
    }

}