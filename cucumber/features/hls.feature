Feature: HLS Manifests
  As Brightcove
  I Want to serve HLS manifests
  So That happy

  @task2
  Scenario: Healthcheck
    When I call GET on "/healthcheck"
    Then the result should be a "200"
