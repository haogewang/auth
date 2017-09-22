var App = {
    ajaxUrl: './',
    alert: function (message) {
        var n = new Date().getDate()
        $('body').append('<div data-n="'+n+'" class="alert alert-'+(arguments[1] || 'danger')+' alert-dismissible fade in"><a href="#" class="close" data-dismiss="alert"> &times; </a><span style="font-size: 20px;margin: 0 20px;" class="glyphicon glyphicon-alert text-'+(arguments[1]||'danger')+'"></span>' + message + '</div>')
        setTimeout(function () {
            $('.alert[data-n="'+n+'"]').removeClass('in').addClass('out').remove()
        }, 3000)
    },
    confirm: function (title, msg, callback) {
        var _html = '<div class="modal fade" id="confirm" tabindex="-1" role="dialog">' +
            '<div class="modal-dialog" role="document">' +
            '<div class="modal-content">' +
            '<div class="modal-header">' +
            '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
            '<h4 class="modal-title">'+ title +'</h4>' +
            '</div>' +
            '<div class="modal-body">' +
            '<p style="font-size: 16px;margin-bottom: 0"><span class="glyphicon glyphicon-exclamation-sign" style="color:#f7ba2a;font-size: 36px;margin: 0 20px;vertical-align: middle"></span>'+msg+'</p>' +
            '</div>' +
            '<div class="modal-footer">' +
            '<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>' +
            '<button type="button" class="btn btn-primary" id="ok">确定</button>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>'
        $('body').append(_html)
        $('#confirm').modal('show')
        $('body').off('click','#ok').on('click','#ok',function () {
            callback()
            $('#confirm').modal('hide')
        })
        $("#confirm").on()
    },
    formatterTime: function (value) {
        var date = new Date(value)
        var Y = date.getFullYear()
        var m = date.getMonth() + 1
        var d = date.getDate()
        var H = date.getHours()
        var i = date.getMinutes()
        var s = date.getSeconds()
        if (m < 10) {
            m = '0' + m
        }
        if (d < 10) {
            d = '0' + d
        }
        if (H < 10) {
            H = '0' + H
        }
        if (i < 10) {
            i = '0' + i
        }
        if (s < 10) {
            s = '0' + s
        }
        var t = Y + '-' + m + '-' + d
        return t
    }
}