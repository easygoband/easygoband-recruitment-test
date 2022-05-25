<template>
    <div :class="'message-box ' + mode">
        <i class="bi bi-info-circle"></i>
        <div>
            <h4>{{ title }}</h4>
            <slot>
                <p>Write your message here</p>
            </slot>
        </div>
    </div>
</template>

<script>
export default {
    name: 'MesageBox',
    props: {
        mode: {
            type: String,
            default: 'info',
        },
    },
    data: function() {
        return {
            title: ''
        };
    },
    mounted: function() {
        this.title = this.mode === 'info' ? 'Information' : 'Error';
    },
}
</script>

<style scoped>
.message-box {
    position: absolute;
    top: 50%;
    left: 50%;
    display: flex;
    padding: 20px 10px;
    transform: translate(-50%, -50%);
}
.info {
    background-color: #e6f9ff;
    border: 1px solid #99e6ff;
}
.error {
    background-color: #fcc;
    border: 1px solid #f33;
}

.message-box > i {
    font-size: 25px;
    margin-right: 10px;
}
</style>
