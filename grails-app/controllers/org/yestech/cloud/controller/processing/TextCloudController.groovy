package org.yestech.cloud.controller.processing

import org.yestech.cloud.TextCloud
import org.yestech.cloud.search.TextCloudService

class TextCloudController {
  TextCloudService textCloudService
  TextCloud textCloud
  
  def index = {
    redener 'please call the service correctly'
  }

  def upload = {
    textCloud = new TextCloud()
    textCloudService.save(textCloud)
    textCloud.addTag("testing")
    textCloudService.save(textCloud)
    render 'done....'
  }

  def loadTag = {
    def textClouds = textCloudService.loadByTag(params.key, params.tag)
    render 'text: ' + textClouds[0].getTags()
  }

  def loadCloud = {
    textCloudService.loadCloud(params.key)
    render 'loaded cloud'
  }
}
