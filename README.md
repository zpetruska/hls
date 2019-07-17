# Overview

Today we're going to build a new microservice which will be part of our next generation media delivery platform.

We strongly recommend that you implement this service in Go (golang). We've included a [barebones Go application](./main.go) to get you started.  There are also barebones [Ruby](./main.rb) and [Java](./Main.java) applications if you prefer to implement in Ruby or Java.

You may use any online resource you want during the exercise.

# Background

Most online video delivery today uses a variant of a "segmented" (chunked) delivery technology.

In segmented delivery, the video player first requests a Manifest file, which contains a list of the URLs of small chunks of media for the player to play, and the duration of each of those segments.

The delivery technology we're using is called "HTTP Live Streaming" (HLS). Here are some examples of some manifests.

1. [2 Second segments](./cucumber/fixtures/expected-manifest-2s-seg.m3u8)
2. [10 Second segments](./cucumber/fixtures/expected-manifest-10s-seg.m3u8).

We're going to build a microservice which generates these HLS manifest files based on some metadata.

<sup>If you want to know more about HLS, [read the Apple developer's guide, here](https://developer.apple.com/library/ios/documentation/NetworkingInternet/Conceptual/StreamingMediaGuide/Introduction/Introduction.html), or [the latest specification here](https://tools.ietf.org/html/draft-pantos-http-live-streaming-19).</sup>

# Task 1

Get the code, put it in place, get the BDD tests running.

NOTE: You will likely be given this repo as a zip file. Place it here if you're implementing in Go:

    $GOPATH/src/github.com/zencoder/fabric-hls-coding-exercise

Install Ruby and Bundler (Ubuntu, YMMV) for running the BDD test suite (depending on your Ruby setup, you may need to use sudo for `gem` as well):

    sudo apt-get install ruby ruby-dev
    gem install bundler

If you're implementing in Ruby, configure bundler in the application directory:

    bundle install

Update the `run.sh` file to uncomment the run command for the language you're implementing in (Go is the default).

Install Cucumber and its dependencies:

    cd cucumber
    bundle install

Running all the tests:

    ./test.sh

Running a specific task:

    bundle exec cucumber -t @task2

NOTE: The Cucumber test runner will run your application using the `run.sh` file.  You do not need the application running ahead of time.

# Task 2

The BDD tests will time out right now waiting for the application to start. We wait 10 seconds for the healthcheck endpoint on the application to start.

Implement a healthcheck handler in the application at `http://localhost:1337/healthcheck` which returns a 200

    GIVEN the application is running
    WHEN call GET on "/healthcheck"
    THEN the result should be a "200"

# What's left?

The rest of the tasks will be provided during your interview. 
